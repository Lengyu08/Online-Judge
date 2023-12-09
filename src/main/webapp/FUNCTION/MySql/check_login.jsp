<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>

<%@ page import="Login_And_Register.CheckLogin" %>

<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String nextPage = "../../login.jsp";

	CheckLogin check_flag = new CheckLogin();

    if (check_flag.checkUser(username, password) && check_flag.checkRepeatedLogin(username)) {
        nextPage = "../../home.jsp";
        // 将用户名存储在 Session 中
        if (username != null && !username.isEmpty()) {
            session.setAttribute("loggedInUsername", username);
            check_flag.loginUser(username);
        }
    } else if (!check_flag.checkRepeatedLogin(username)) {
        session.setAttribute("Error", "RepeatedLoginError");
    } else {
        session.setAttribute("Error", "LoginError");
    }

	response.sendRedirect(nextPage);
%>
