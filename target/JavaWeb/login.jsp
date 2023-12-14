<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<%
    String Error = (String)session.getAttribute("Error");
    session.removeAttribute("Error");
%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/CSS/navbar.css"/>
    <link rel="stylesheet" type="text/css" href="/CSS/login_register.css"/>
</head>
<body>

<%@ include file="navbar.jsp"%>

<div class="operation_interface">
    <div class="icon">
        <img src="./STATIC-RESOURCES/IMAGE/icon/logo.png" style="width: 50%; height: auto" style="text-align: center;"/>
    </div>
    <br/>
    <form id="loginForm" method="post" action="./FUNCTION/MySql/check_login.jsp">
        <span style="color: white">用户名:</span>&nbsp;
        <span class="user">
          <label>
            <input type="text" name="username" placeholder="请输入用户名" style="width: 70%"/>
          </label>
        </span>
        <br/><br/>
        <span style="color: white">密码:</span>&nbsp;&nbsp;&nbsp;&nbsp;
        <span class="user">
          <input type="password" name="password" placeholder="请输入密码" style="width: 70%"/>
        </span>
        <br/><br/>
        <span>
          <a href="#" onclick="submitLoginForm()">登录</a>&nbsp;
          <a href="./register.jsp">没有账号，现在注册</a>
        </span>
        <br/><br/>
    </form>
</div>

<script>
  function submitLoginForm() {
    const usernameField = document.getElementsByName("username")[0]; // 使用 getElementsByName 来访问输入字段
    console.log(usernameField);
    if (usernameField.value.trim() === '') {
      alert("用户名不能为空。");
    } else {
      document.getElementById("loginForm").submit();
    }
  }
</script>

<% if ("LoginError".equals(Error)) { %>
<script type="text/javascript">
  window.onload = function () {
    setTimeout(function () {
      alert("用户名或密码错误！");
    }, 100);
  }
</script>
<% } else if ("RepeatedLoginError".equals(Error)) {%>
<script type="text/javascript">
  window.onload = function () {
    setTimeout(function () {
      alert("请勿重复登录！");
    }, 100);
  }
</script>
<% } %>
</body>
</html>


