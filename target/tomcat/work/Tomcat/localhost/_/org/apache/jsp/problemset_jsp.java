/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2023-12-08 12:35:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import Login_And_Register.CheckLogin;

public final class problemset_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
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

      out.write('\r');
      out.write('\n');
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\"/>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\r\n");
      out.write("    <title>ProblemSet</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./CSS/navbar.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./CSS/content.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./CSS/footer.css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- Navbar Start -->\r\n");
      out.write("<nav class=\"navbar\">\r\n");
      out.write("    <a href=\"javascript:location.reload(true)\">\r\n");
      out.write("        <!-- 刷新本页 -->\r\n");
      out.write("        <img src=\"./STATIC-RESOURCES/IMAGE/icon/logo.png\" alt=\"按钮\" width=\"15%\"/>\r\n");
      out.write("    </a>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"navbar-links\">\r\n");
      out.write("        <a href=\"./home.jsp\">首页</a>\r\n");
      out.write("        <a href=\"./problemset.jsp\">题库</a>\r\n");
      out.write("        <a href=\"./item.jsp\">项目</a>\r\n");
      out.write("\r\n");
      out.write("        ");
 if (loggedInUsername == null || loggedInUsername.isEmpty()) { 
      out.write("\r\n");
      out.write("        <a href=\"./login.jsp\">登录</a>\r\n");
      out.write("        <a href=\"./register.jsp\">注册</a>\r\n");
      out.write("        ");
 } else { 
      out.write("\r\n");
      out.write("        <a>\r\n");
      out.write("            ");
      out.print( loggedInUsername );
      out.write("\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"?logout=true\">登出</a>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<!-- Navbar End -->\r\n");
      out.write("\r\n");
      out.write("<!-- Content Start -->\r\n");
      out.write("<div class=\"content\">\r\n");
      out.write("    <div class=\"content\">\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题目</th>\r\n");
      out.write("                <th>难度</th>\r\n");
      out.write("                <th>类型</th>\r\n");
      out.write("                <th>提交人数</th>\r\n");
      out.write("                <th>通过人数</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td><a href=\"/PROBLEMSET/1.jsp\">a+b</a></td>\r\n");
      out.write("                <td>简单</td>\r\n");
      out.write("                <td>语法题</td>\r\n");
      out.write("                <td>100</td>\r\n");
      out.write("                <td>80</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td><a href=\"/PROBLEMSET/2.jsp\">迷宫问题</a></td>\r\n");
      out.write("                <td>中等</td>\r\n");
      out.write("                <td>深度优先搜索</td>\r\n");
      out.write("                <td>200</td>\r\n");
      out.write("                <td>150</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td><a href=\"/PROBLEMSET/3.jsp\">旅行商问题</a></td>\r\n");
      out.write("                <td>困难</td>\r\n");
      out.write("                <td>启发式, 模拟退火</td>\r\n");
      out.write("                <td>1000</td>\r\n");
      out.write("                <td>100</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Content End -->\r\n");
      out.write("\r\n");
      out.write("<!-- Footer Start -->\r\n");
      out.write("<footer class=\"site-footer\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"footer-content\">\r\n");
      out.write("            <div class=\"footer-section\">\r\n");
      out.write("                <a>关于我们</a>\r\n");
      out.write("                <p>这里是一个项目和刷题展示的网站</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>\r\n");
      out.write("<!-- Footer End -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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