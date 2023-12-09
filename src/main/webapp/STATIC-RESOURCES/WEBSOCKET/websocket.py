import asyncio
import websockets

# 存储所有连接的WebSocket客户端
clients = set()
users = set()

async def handle_connection(websocket, path):
    # 添加新连接到客户端集合
    clients.add(websocket)

    # 解析 planWebsocket = new WebSocket('ws://'+ planIP +':' + planPort + "?<%=loggedInUsername%>")
    username = path.split('?')[1]
    users.add(username) 

    # 提示信息
    alter_message = "chat:message:" + username + "加入了聊天"

    # 发送消息给全部成员
    await asyncio.gather(*[client.send(alter_message) for client in clients])

    try:
        while True:
            # 接收消息
            message = await websocket.recv()
            print(f"Received message: {message}")
            chat_message = "chat:" + username + ":" + message
            # 发送消息给全部成员
            await asyncio.gather(*[client.send(chat_message) for client in clients])
    except websockets.exceptions.ConnectionClosedError:
        print("Connection is closed.")
    finally:
        clients.remove(websocket)
        users.remove(username)
        alter_message = "message:" + username + "离开了聊天"
        # 发送消息给全部成员
        await asyncio.gather(*[client.send(alter_message) for client in clients])

# 定时向所有连接的客户端发送消息
async def send_messages():
    while True:
        # 发送在线用户给所有人
        message = "user:"
        for user in users:
            message += " " + user
        # 向所有客户端发送消息
        await asyncio.gather(*[client.send(message) for client in clients])
        # 等待一段时间
        await asyncio.sleep(1)

# 启动WebSocket服务器
async def main():
    server = await websockets.serve(handle_connection, "localhost", 9090)
    print("WebSocket server started.")
    
    # 启动定时发送消息的任务
    asyncio.create_task(send_messages())
    
    # 等待服务器关闭
    await server.wait_closed()

# 启动主循环
asyncio.run(main())