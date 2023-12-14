<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<nav class="navbar">
  <a href="javascript:location.reload()">
    <img src="/STATIC-RESOURCES/IMAGE/icon/logo.png" alt="按钮" width="15%"/>
  </a>

  <div class="navbar-links">
    <a href="/home.jsp">首页</a>
    <a href="/problemset.jsp">题库</a>
    <a href="/item.jsp">项目</a>

    <% if (loggedInUsername == null || loggedInUsername.isEmpty()) { %>
    <a href="/login.jsp">登录</a>
    <a href="/register.jsp">注册</a>
    <% } else { %>
    <a href="/ITEM/1.jsp">
      <%= loggedInUsername %>
    </a>
    <a href="?logout=true">登出</a>
    <% } %>
  </div>
</nav>
