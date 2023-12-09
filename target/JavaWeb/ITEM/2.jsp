<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@ include file="/header.jsp" %>

<%
  String Error = (String)session.getAttribute("Error");
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <title>Match</title>
  <link rel="stylesheet" type="text/css" href="../CSS/navbar.css"/>
  <link rel="stylesheet" type="text/css" href="../CSS/content.css"/>
  <link rel="stylesheet" type="text/css" href="../CSS/footer.css"/>
  <style>
    .sublime_code {
        font-size: 24px;
        display: inline-block;
        padding: 10px 20px;
        border-radius: 20px;
        background-color: #b0acac;
        color: #020202;
        text-decoration: none;
        transition: background-color 0.3s;
        cursor: pointer;
    }

    .sublime_code:hover {
        background-color: #555555; /* Change the background color on hover */
        color: #ffffff;
    }

    #main_img {
        max-width: 100%;
        max-height: 100%;
        width: auto;
        height: auto;
    }
  </style>
</head>

<body>
<%@include file="/navbar.jsp"%>

<div class="content">
  <div class="content" style="min-height: auto;">
    <img id="main_img" src="/STATIC-RESOURCES/IMAGE/item/match.jpg" alt="none"/>
  </div>
  <a href="/servlet/Match" class="sublime_code">开始匹配</a>
</div>

<%@include file="/footer.jsp"%>
</body>

<% if ("Please_Login".equals(Error)) { %>
<script type="text/javascript">
  window.onload = function () {
    setTimeout(function () {
      alert("请先登录再进入匹配系统");
      <% session.removeAttribute("Error"); %>
    }, 100);
  }
</script>
<% } else if ("Win".equals(Error)) {%>
<script type="text/javascript">
  window.onload = function () {
    setTimeout(function () {
      alert("你赢得了比赛");
      <% session.removeAttribute("Error"); %>
    }, 100);
  }
</script>
<% } else if ("Lose".equals(Error)) {%>
<script type="text/javascript">
  window.onload = function () {
    setTimeout(function () {
      alert("你输掉了比赛");
      <% session.removeAttribute("Error"); %>
    }, 100);
  }
</script>
<% } else if ("Draw".equals(Error)) { %>
<script type="text/javascript">
  window.onload = function () {
    setTimeout(function () {
      alert("平局!");
      <% session.removeAttribute("Error"); %>
    }, 100);
  }
</script>
<% } %>
</html>