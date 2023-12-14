<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>ProblemSet</title>
    <link rel="stylesheet" type="text/css" href="./CSS/navbar.css"/>
    <link rel="stylesheet" type="text/css" href="./CSS/content.css"/>
    <link rel="stylesheet" type="text/css" href="./CSS/footer.css"/>
</head>
<body>
<!-- Navbar Start -->
<nav class="navbar">
    <a href="javascript:location.reload(true)">
        <!-- 刷新本页 -->
        <img src="./STATIC-RESOURCES/IMAGE/icon/logo.png" alt="按钮" width="15%"/>
    </a>

    <div class="navbar-links">
        <a href="./home.jsp">首页</a>
        <a href="./problemset.jsp">题库</a>
        <a href="./item.jsp">项目</a>

        <% if (loggedInUsername == null || loggedInUsername.isEmpty()) { %>
        <a href="./login.jsp">登录</a>
        <a href="./register.jsp">注册</a>
        <% } else { %>
        <a>
            <%= loggedInUsername %>
        </a>
        <a href="?logout=true">登出</a>
        <% } %>
    </div>
</nav>
<!-- Navbar End -->

<!-- Content Start -->
<div class="content">
    <div class="content">
        <table>
            <tr>
                <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题目</th>
                <th>难度</th>
                <th>类型</th>
                <th>提交人数</th>
                <th>通过人数</th>
            </tr>
            <tr>
                <td><a href="/PROBLEMSET/1.jsp">a+b</a></td>
                <td>简单</td>
                <td>语法题</td>
                <td>100</td>
                <td>80</td>
            </tr>
            <tr>
                <td><a href="/PROBLEMSET/2.jsp">迷宫问题</a></td>
                <td>中等</td>
                <td>深度优先搜索</td>
                <td>200</td>
                <td>150</td>
            </tr>
            <tr>
                <td><a href="/PROBLEMSET/3.jsp">旅行商问题</a></td>
                <td>困难</td>
                <td>启发式, 模拟退火</td>
                <td>1000</td>
                <td>100</td>
            </tr>
        </table>
    </div>
</div>
<!-- Content End -->

<!-- Footer Start -->
<footer class="site-footer">
    <div class="container">
        <div class="footer-content">
            <div class="footer-section">
                <a>关于我们</a>
                <p>这里是一个项目和刷题展示的网站</p>
            </div>
        </div>
    </div>
</footer>
<!-- Footer End -->
</body>
</html>
