<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<%
  String Error = (String) session.getAttribute("Error");
  session.removeAttribute("Error");    // 清除该属性，以防重复显示警告
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Register</title>
  <link rel="stylesheet" type="text/css" href="./CSS/navbar.css"/>
  <link rel="stylesheet" type="text/css" href="./CSS/login_register.css"/>
</head>
<body>

<%@ include file="navbar.jsp"%>

<div class="operation_interface" style="transform: translate(-50%, -45%); width: 350px">
  <div class="icon">
    <img alt="" src="./STATIC-RESOURCES/IMAGE/icon/logo.png" style="width: 50%; height: auto"/>
  </div>
  <br/>
  <form action="./FUNCTION/MySql/check_register.jsp" method="post">
    <span>用户名:</span>&nbsp;
    <span class="user">
        <label>
          <input type="text" name="username" placeholder="请输入用户名" style="width: 70%"/>
        </label>
      </span>
    <br/><br/>
    <span>密码:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <span class="user">
        <label>
          <input type="password" name="password" placeholder="请输入密码" style="width: 70%"/>
        </label>
      </span>
    <br/><br/>
    <span>邮箱:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <span class="user">
        <label>
          <input type="email" name="email" placeholder="请输入邮箱" style="width: 70%"/>
        </label>
      </span>
    <br/><br/>
    <span>手机号:</span>&nbsp;&nbsp;
    <span>
   <label>
        <input type="text" placeholder="请输入手机号" style="width: 45%"/>&nbsp;
   </label>
        <a style="padding: 8px 8px">现在验证</a>
    </span>
    <br/><br/>
    <span>兴趣爱好:</span>
    <label>
      <select class="hobby" style="width: 65%">
        <option value="choose" name="hobby" selected disabled hidden>
          请选择你的技术栈
        </option>
        <option value="c++">C++</option>
        <option value="java">Java</option>
        <option value="python">Python</option>
        <option value="web">Web</option>
      </select>
    </label>
    <br/><br/>

    <span>性别:</span>&nbsp;&nbsp;&nbsp;&nbsp;
    <label>
      <input type="radio" name="sex" checked="" class="radio-mark"/>
    </label>
    <label><span>男</span></label>
    <label>
      <input type="radio" name="sex" checked="" class="radio-mark"/>
    </label>
    <label><span>女</span></label>

    <br/><br/>
    <span style="color: white">刷题时间:</span>
    <label>
      <input type="checkbox" name="login_time" value="morning"/>
      <span class="checkbox-mark"></span>
      <span>上午</span>
    </label>
    <label>
      <input type="checkbox" name="login_time" value="afternoon"/>
      <span class="checkbox-mark"></span>
      <span>下午</span>
    </label>
    <label>
      <input type="checkbox" name="login_time" value="evening"/>
      <span class="checkbox-mark"></span>
      <span>晚上</span>
    </label>
    <br/><br/>

    <span>
        <button type="submit" class="button">提交注册, 转到登录界面</button>
      </span>
    <br/><br/>
  </form>
</div>

<% if ("Register Username Or Password Error".equals(Error)) { %>
<script type="text/javascript">
  window.onload = function () {
    setTimeout(function () {
      alert("用户名或密码不能为空！");
    }, 100);
  }
</script>
<% } else if ("Username Repeat".equals(Error)) { %>
<script type="text/javascript">
  window.onload = function () {
    setTimeout(function () {
      alert("用户名已存在！");
    }, 100);
  }
</script>
<% } %>
</body>
</html>
