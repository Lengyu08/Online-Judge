<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>

<%@ page import="Login_And_Register.CheckRegister" %>

<%
    CheckRegister ref = new CheckRegister();
	
    String username 		= request.getParameter("username");
    String password 		= request.getParameter("password");
    String nextPage 		= "../../register.jsp";

    if (username == null || password == null) {
    	session.setAttribute("Error", "Register Username Or Password Error");
    } else if (ref.checkRepeatName(username)) {
    	session.setAttribute("Error", "Username Repeat");
    } else {
        nextPage = "../../login.jsp";
        // 检查完毕开始记录用户数据
        String email 			      = request.getParameter("email");
        String phoneNumber 		  = request.getParameter("phone");
        String hobby 			      = request.getParameter("hobby");
        String gender 			    = request.getParameter("sex");
        String[] loginTime 		  = request.getParameterValues("login_time");
        String loginTime_result = null;

        int morning_cnt = 0; int afternoon_cnt = 0; int evening_cnt = 0;
        
        // 计算用户登录的时间为后续做表格
        if (loginTime == null) {
            loginTime_result = "none";
        } else if (loginTime.length == 3) {
            loginTime_result = "all";
            morning_cnt = 1; afternoon_cnt = 1; evening_cnt = 1;
        } else {
            for (int i = 0; i < loginTime.length; i ++ ) {
                if (loginTime[i].equals("morning") && loginTime[i] != null) {
                    loginTime_result += " morning ";
                    morning_cnt = 1;
                } else if (loginTime[i].equals("afternoon") && loginTime[i] != null) {
                    loginTime_result += " afternoon ";
                    afternoon_cnt = 1;
                } else if (loginTime[i].equals("evening") && loginTime[i] != null) {
                    loginTime_result += " evening ";
                    evening_cnt = 1;
                }
            }
        }

        // 提交到 Mysql
        ref.referToMysql(
            username, password, email, 
            phoneNumber, hobby, gender,
            loginTime_result,
            morning_cnt, afternoon_cnt, evening_cnt 
        ); 
    }

    response.sendRedirect(nextPage);
%>
