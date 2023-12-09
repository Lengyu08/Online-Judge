<%@ page import="Login_And_Register.CheckLogin" %>

<%
  request.setCharacterEncoding("utf-8");
  response.setCharacterEncoding("utf-8");

  String loggedInUsername = (String) session.getAttribute("loggedInUsername");
  // 如果需要登出，从 Session 中删除用户名
  String logout = request.getParameter("logout");
  if ("true".equals(logout)) {
    new CheckLogin().logoutUser(loggedInUsername);
    session.removeAttribute("loggedInUsername");
    response.sendRedirect("/home.jsp");
  }
%>
