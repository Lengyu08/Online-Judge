<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<%
    String Error = (String) session.getAttribute("Error");
    session.removeAttribute("Error");
%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Item</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="./CSS/navbar.css"/>
    <link rel="stylesheet" type="text/css" href="./CSS/content.css"/>
    <link rel="stylesheet" type="text/css" href="./CSS/footer.css"/>
    <style type="text/css">
        #slideshow {
            width: 800px;
            height: 500px;
            margin: 0 auto;
            overflow: hidden;
            position: relative; /* 添加相对定位 */
        }

        #slideshow img {
            max-width: 100%;
            max-height: 100%;
            width: auto;
            height: auto;
            position: absolute; /* 添加绝对定位 */
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%); /* 居中显示图像 */
        }

        .slideshow-sub {
            background-color: #ffffff; /* 设置内容区的背景颜色为白色 */
            padding: 20px; /* 设置内容区的内边距为20像素 */
            border-radius: 10px; /* 设置内容区的边框圆角为10像素 */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 添加内容区的阴影效果 */
            margin: 50% 5%;
        }
        .slideshow-sub:hover {
            background-color: #000000; /* 设置内容区的背景颜色为白色 */
            color: white;
        }
    </style>
</head>
<body>
<%@ include file="navbar.jsp" %>

<!-- Content Start -->
<div class="content" style="min-height: auto">
    <!-- Slideshow Start -->
    <h1 style="font-size: 70px; font-family: 楷体,serif">最近项目</h1>
    <div class="content" style="margin: 3% 10%; display: flex; min-height: auto;">
        <div class="content" style="min-height: auto">
            <div class="slideshow-sub" id="sub-1">管理面板</div>
            <div class="slideshow-sub" id="sub-2">匹配系统</div>
            <div class="slideshow-sub" id="sub-3">聊天系统</div>
        </div>
        <div id="slideshow">
            <img id="img1" src="/STATIC-RESOURCES/IMAGE/item/manger.jpg" alt="Image 1"/>
            <img id="img2" src="/STATIC-RESOURCES/IMAGE/item/match.jpg" alt="Image 2" style="display: none;"/>
            <img id="img3" src="/STATIC-RESOURCES/IMAGE/item/wechat.jpg" alt="Image 3" style="display: none;"/>
        </div>
    </div>
    <script src="/JS/slidshow.js"></script>
    <!-- Slideshow End -->
    <h1 style="font-size: 70px; font-family: 楷体,serif">全部项目</h1>
    <div class="project" id="1">
        <div class="project-image">
            <img src="/STATIC-RESOURCES/IMAGE/item/manger.jpg" />
        </div>
        <div class="project-details">
            <a href="" style="font-size: xxx-large">后台管理面板</a>
            <br /><br />
            <div class="project-info">
                <p>用户可以发送意见给网站, 管理员可以添加题目和管理用户, root 用户拥有最高权限</p>
                <p>
                    <b>GitHub地址:&nbsp;https://github.com/your-repo</b>
                </p>
                <p>项目负责人:张维桓</p>
            </div>
        </div>
    </div>
    <div class="project" id="2">
        <div class="project-image">
            <img src="/STATIC-RESOURCES/IMAGE/item/match.jpg" />
        </div>
        <div class="project-details">
            <a href="" style="font-size: xxx-large">匹配系统</a>
            <br /><br />
            <div class="project-info">
                <p>java servlet 制作的匹配系统, 快叫上你的好友来一把</p>
                <p>
                    <b>GitHub地址:&nbsp;https://github.com/your-repo</b>
                </p>
                <p>项目负责人:张维桓</p>
            </div>
        </div>
    </div>
    <div class="project" id="3">
        <div class="project-image">
            <img src="/STATIC-RESOURCES/IMAGE/item/wechat.jpg" />
        </div>
        <div class="project-details">
            <a href="" style="font-size: xxx-large">聊天系统</a>
            <br /><br />
            <div class="project-info">
                <p>交流项目经验</p>
                <p>
                    <b>GitHub地址:&nbsp;https://github.com/your-repo</b>
                </p>
                <p>项目负责人:张维桓</p>
            </div>
        </div>
    </div>
</div>
<!-- Content End -->
<script src="/JS/item.js"></script>

<%@ include file="footer.jsp" %>
</body>

<% if ("ChatLoginError".equals(Error)) { %>
<script type="text/javascript">
    window.onload = function () {
        setTimeout(function () {
            alert("不接受非登录用户进入聊天室!");
        }, 100);
    }
</script>
<% } %>
</html>
