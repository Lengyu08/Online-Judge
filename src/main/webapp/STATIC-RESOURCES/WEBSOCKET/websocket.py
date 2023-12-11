import os
import ssl
import tornado.web
import tornado.ioloop
import tornado.websocket
import tornado.httpserver

# 存储所有连接的WebSocket客户端
users = set()
clients = set()

class WebSocketHandler(tornado.websocket.WebSocketHandler):

    def check_origin(self, origin):
        # 允许所有Origin连接
       return True

    def open(self): 
        print("连接中 ......")

        # 添加新连接到客户端集合
        clients.add(self)

        # 解析 username
        self.username = self.get_argument("username", default="")
        print("username : " + self.username + " is coming")
        users.add(self.username)

        # 提示信息
        alter_message = "chat:message:" + self.username + "加入了聊天"

        print("准备发送信息")
        # 发送消息给全部成员
        tornado.ioloop.IOLoop.current().add_callback(self.broadcast, alter_message)

    def on_message(self, message):
        print(f"接收信息: {message}")
        
        # 确保在使用之前正确设置了 self.username
        if not hasattr(self, 'username'):
            self.username = self.get_argument("username", default="")
        
        # 发送消息给全部成员, 用户的到来信息
        chat_message = "chat:" + self.username + ":" + message
        self.broadcast(chat_message)
        

    def on_close(self, close_code=None, close_reason=None):
        print(f"Connection closed for {self.username} with code: {close_code}, reason: {close_reason}")
        if self.close_code is None:
            # 从集合中删除
            clients.remove(self)
            users.remove(self.username)

            # 发送消息给全部成员
            alter_message = "message:" + self.username + "离开了聊天"
            self.broadcast(alter_message)

            # 关闭码
            self.close(1000, "正常关闭")


    def broadcast(self, message):
        print("广播信息" + message)
        # 创建一个空集合来存储需要移除的客户端
        to_remove = set()
        
        # 遍历 'clients' 集合中的每个客户端
        for client in clients:
            # 检查客户端的 close_code 是否为 None，并且 WebSocket 连接未关闭
            if client.close_code is None:
                try:
                    # 尝试使用 write_message 方法向客户端发送消息
                    client.write_message(message)
                except tornado.websocket.WebSocketClosedError:
                    print("客户端发生错误, 信息未发送成功")
                    # 如果发生 WebSocketClosedError，将客户端添加到 'to_remove' 集合中
                    to_remove.add(client)

        # 从 'clients' 集合中移除已关闭的连接
        clients.difference_update(to_remove)
    
    def broadcast_users(self):
        # 每隔1s广播用户集合
        user_list = "user:"
        for user in users:
            user_list += user + " "
        self.broadcast(user_list)

class MainHandler(tornado.web.RequestHandler):
    def get(self):
        self.write("WebSocket server is running.")

def make_app():
    return tornado.web.Application([
        (r"/", MainHandler),
        (r"/ws", WebSocketHandler),
    ])

if __name__ == "__main__":
    # # ssl wss
    # # ssl_certificate /etc/letsencrypt/live/app2619.acapp.acwing.com.cn/fullchain.pem;
    # # ssl_certificate_key /etc/letsencrypt/live/app2619.acapp.acwing.com.cn/privkey.pem;
    data_dir = "/etc/letsencrypt/live/app2619.acapp.acwing.com.cn"
    ssl_ctx = ssl.create_default_context(ssl.Purpose.CLIENT_AUTH)
    ssl_ctx.load_cert_chain(os.path.join(data_dir, "fullchain.pem"), os.path.join(data_dir, "privkey.pem"))
    
    app = make_app()
    
    # print("WebSocket APP server started.")
    # app.listen(9090)

    print("WebSocket HTTP server started.")
    http_server = tornado.httpserver.HTTPServer(app, xheaders=True, ssl_options=ssl_ctx)
    # http_server = tornado.httpserver.HTTPServer(app)
    http_server.listen(9090);

    # 添加定时任务，每隔1s调用一次广播用户集合的方法
    periodic_callback = tornado.ioloop.PeriodicCallback(
        lambda: clients and next(iter(clients)).broadcast_users(),
        1000  # 1000 毫秒 = 1 秒
    )
    periodic_callback.start()

    tornado.ioloop.IOLoop.current().start()