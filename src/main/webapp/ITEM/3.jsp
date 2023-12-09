<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/header.jsp" %>

<%
  if (loggedInUsername == null || loggedInUsername.isEmpty()) {
      session.setAttribute("Error", "ChatLoginError");
      response.sendRedirect("../item.jsp");
  }
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <title>Chat Room</title>
  <link rel="stylesheet" type="text/css" href="../CSS/navbar.css"/>
  <link rel="stylesheet" type="text/css" href="../CSS/content.css"/>
  <link rel="stylesheet" type="text/css" href="../CSS/chat.css">
</head>

<body>
<%@include file="/navbar.jsp" %>

<div class="content">
  <div id="friend_char_area">
    <span id="friendList">
      <h2>在线用户</h2>
      <div id="onlineList" class="friend" style="border: #d0d0d0 solid 3px;">
      </div>
    </span>

    <span id="chatArea">
      <h2>聊天区</h2>
      <span id="chatContext">
      </span>
    </span>

  </div>
  <div id="inputArea">
    <textarea id="messageInput" placeholder="输入消息..." rows="4"></textarea>
    <button id="sendButton">发送</button>
  </div>
</div>

<script>
  let planWebsocket = null;
  function initWebpack() {//初始化websocket
    if ('WebSocket' in window) {
      planWebsocket = new WebSocket("ws://localhost:9090?<%=loggedInUsername%>"); // 通信地址
      planWebsocket.onopen = function (event) {
        console.log('建立连接');
      }

      planWebsocket.onmessage = function (event) {
        console.log('收到消息:' + event.data)
        let str_data = event.data;
        // 如果字符串是 "user:" 开头的, 就是用户列表
        if (str_data.startsWith("user:")) {
          // 清空在线列表
          document.getElementById('onlineList').innerHTML = '';
          // 获取用户列表 // 空格作为分隔符
          let user_list = str_data.substring(5).split(' ');
          // 遍历用户列表
          for (let i = 0; i < user_list.length; i++) {
            // 创建一个 div
            let div = document.createElement('div');
            // 设置 div 的内容
            div.innerHTML = user_list[i];
            // 添加到在线列表
            document.getElementById('onlineList').appendChild(div);
          }
        } else if (str_data.startsWith("chat:")) {
          if (str_data.substring(5).startsWith("<%=loggedInUsername%>:")) {
            // 放到聊天区作为自己输入
            document.getElementById("chatContext").innerHTML += "<p style=" +
                "'float: right; border: gray solid 3px; margin-top: 10px; border-radius:10px; background-color: rgb(137, 217, 97);'>" +
                "<span class='chatFont'>"
                  + str_data.substring(5) +
                "</span></p>";
            document.getElementById("chatContext").innerHTML += "<br/><br/><br/><br/><br/>";
          } else if (str_data.substring(5).startsWith("message:")) {
            // 放到聊天区作为提示信息
            document.getElementById("chatContext").innerHTML += "<p style=''><span class='chatFont' style='font-size: 15px;'>" + str_data.substring(13) + "</span></p>";
          } else {
            // 放到聊天区作为其他用户输入
            document.getElementById("chatContext").innerHTML += "<p style=" +
                "'float: left; border: gray solid 3px; margin-top: 10px; border-radius:10px; background-color: white;'>" +
                "<span class='chatFont'>"
                  + str_data.substring(5) +
                "</span></p>";
            document.getElementById("chatContext").innerHTML += "<br/><br/><br/><br/><br/>";
          }
        }
      }

      planWebsocket.onclose = function (event) {
        console.log('连接关闭');
      }

      planWebsocket.onerror = function () {
        alert('websocket通信发生错误！');
      }

      // 发送 button 的消息
      document.getElementById('sendButton').onclick = function () {
        let messageInput = document.getElementById('messageInput');
        let message = messageInput.value;
        planWebsocket.send(message);
        messageInput.value = '';
      }
    } else {
      alert('该浏览器不支持websocket!');
    }
  }

  initWebpack(); //调用
</script>
</body>
</html>
