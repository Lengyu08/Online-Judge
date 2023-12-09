<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@ include file="/header.jsp" %>

<%@page import="Manger.GetLevel" %>

<%
  if (loggedInUsername == null || loggedInUsername.isEmpty() || new GetLevel().getLevel(loggedInUsername) < 0) {
    session.setAttribute("Error", "ChatLoginError");
    response.sendRedirect("../item.jsp");
  }
  int right_leve = new GetLevel().getLevel(loggedInUsername);
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <title>Chat</title>
  <link rel="stylesheet" type="text/css" href="../CSS/navbar.css"/>
  <link rel="stylesheet" type="text/css" href="../CSS/content.css"/>
  <link rel="stylesheet" type="text/css" href="../CSS/footer.css"/>

  <link rel="stylesheet" type="text/css" href="/LIB/Bootstrap/bootstrap.min.css"/>
</head>

<body>
<%@include file="/navbar.jsp" %>

<div class="content">

<% if (right_leve == 0) { %>
  <%@include file="./1.Manger/0.root.jsp" %>
<% } else if (right_leve == 1) { %>
  <%@include file="./1.Manger/1.adminer.jsp" %>
<% } else if (right_leve == 2) { %>
  <%@include file="./1.Manger/2.user.jsp" %>
<% } %>

</div>

<%@include file="/footer.jsp" %>
</body>
</html>