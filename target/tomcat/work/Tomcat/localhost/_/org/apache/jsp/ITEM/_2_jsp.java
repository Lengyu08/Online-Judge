/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2023-12-08 13:46:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.ITEM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import Login_And_Register.CheckLogin;
import java.util.*;
import java.util.*;

public final class _2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/navbar.jsp", Long.valueOf(1702036038760L));
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1702036038684L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1702036038688L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

  request.setCharacterEncoding("utf-8");
  response.setCharacterEncoding("utf-8");

  String loggedInUsername = (String) session.getAttribute("loggedInUsername");
  // å¦æéè¦ç»åºï¼ä» Session ä¸­å é¤ç¨æ·å
  String logout = request.getParameter("logout");
  if ("true".equals(logout)) {
    new CheckLogin().logoutUser(loggedInUsername);
    session.removeAttribute("loggedInUsername");
    response.sendRedirect("/home.jsp");
  }

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");

  String Error = (String)session.getAttribute("Error");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\"/>\r\n");
      out.write("  <title>Match</title>\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"../CSS/navbar.css\"/>\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"../CSS/content.css\"/>\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"../CSS/footer.css\"/>\r\n");
      out.write("  <style>\r\n");
      out.write("    .sublime_code {\r\n");
      out.write("        font-size: 24px;\r\n");
      out.write("        display: inline-block;\r\n");
      out.write("        padding: 10px 20px;\r\n");
      out.write("        border-radius: 20px;\r\n");
      out.write("        background-color: #b0acac;\r\n");
      out.write("        color: #020202;\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        transition: background-color 0.3s;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .sublime_code:hover {\r\n");
      out.write("        background-color: #555555; /* Change the background color on hover */\r\n");
      out.write("        color: #ffffff;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #main_img {\r\n");
      out.write("        max-width: 100%;\r\n");
      out.write("        max-height: 100%;\r\n");
      out.write("        width: auto;\r\n");
      out.write("        height: auto;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar\">\r\n");
      out.write("  <a href=\"javascript:location.reload()\">\r\n");
      out.write("    <img src=\"/STATIC-RESOURCES/IMAGE/icon/logo.png\" alt=\"按钮\" width=\"15%\"/>\r\n");
      out.write("  </a>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"navbar-links\">\r\n");
      out.write("    <a href=\"/home.jsp\">首页</a>\r\n");
      out.write("    <a href=\"/problemset.jsp\">题库</a>\r\n");
      out.write("    <a href=\"/item.jsp\">项目</a>\r\n");
      out.write("\r\n");
      out.write("    ");
 if (loggedInUsername == null || loggedInUsername.isEmpty()) { 
      out.write("\r\n");
      out.write("    <a href=\"/login.jsp\">登录</a>\r\n");
      out.write("    <a href=\"/register.jsp\">注册</a>\r\n");
      out.write("    ");
 } else { 
      out.write("\r\n");
      out.write("    <a href=\"/ITEM/1.jsp\">\r\n");
      out.write("      ");
      out.print( loggedInUsername );
      out.write("\r\n");
      out.write("    </a>\r\n");
      out.write("    <a href=\"?logout=true\">登出</a>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"content\">\r\n");
      out.write("  <div class=\"content\" style=\"min-height: auto;\">\r\n");
      out.write("    <img id=\"main_img\" src=\"/STATIC-RESOURCES/IMAGE/item/match.jpg\" alt=\"none\"/>\r\n");
      out.write("  </div>\r\n");
      out.write("  <a href=\"/servlet/Match\" class=\"sublime_code\">开始匹配</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<footer class=\"site-footer\">\r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("    <div class=\"footer-content\">\r\n");
      out.write("      <div class=\"footer-section\">\r\n");
      out.write("        <a>关于我们</a>\r\n");
      out.write("        <p>这里是一个项目和刷题展示的网站</p>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</footer>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
 if ("Please_Login".equals(Error)) { 
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  window.onload = function () {\r\n");
      out.write("    setTimeout(function () {\r\n");
      out.write("      alert(\"请先登录再进入匹配系统\");\r\n");
      out.write("      ");
 session.removeAttribute("Error"); 
      out.write("\r\n");
      out.write("    }, 100);\r\n");
      out.write("  }\r\n");
      out.write("</script>\r\n");
 } else if ("Win".equals(Error)) {
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  window.onload = function () {\r\n");
      out.write("    setTimeout(function () {\r\n");
      out.write("      alert(\"你赢得了比赛\");\r\n");
      out.write("      ");
 session.removeAttribute("Error"); 
      out.write("\r\n");
      out.write("    }, 100);\r\n");
      out.write("  }\r\n");
      out.write("</script>\r\n");
 } else if ("Lose".equals(Error)) {
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  window.onload = function () {\r\n");
      out.write("    setTimeout(function () {\r\n");
      out.write("      alert(\"你输掉了比赛\");\r\n");
      out.write("      ");
 session.removeAttribute("Error"); 
      out.write("\r\n");
      out.write("    }, 100);\r\n");
      out.write("  }\r\n");
      out.write("</script>\r\n");
 } else if ("Draw".equals(Error)) { 
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  window.onload = function () {\r\n");
      out.write("    setTimeout(function () {\r\n");
      out.write("      alert(\"平局!\");\r\n");
      out.write("      ");
 session.removeAttribute("Error"); 
      out.write("\r\n");
      out.write("    }, 100);\r\n");
      out.write("  }\r\n");
      out.write("</script>\r\n");
 } 
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
