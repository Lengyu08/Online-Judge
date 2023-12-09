<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="./CSS/navbar.css"/>
    <link rel="stylesheet" type="text/css" href="./CSS/content.css"/>
    <link rel="stylesheet" type="text/css" href="./CSS/footer.css"/>
</head>
<body>
<%@ include file="navbar.jsp" %>

<!-- Content Start -->
<div class="content">
    <h1>每日新闻</h1>
    <video src="./STATIC-RESOURCES/VIDEO/icpc.mp4" style="width: 70%" controls autoplay>
        <!-- 在 src 属性中指定视频文件的路径 -->
        <!-- controls 属性显示视频控件，允许用户控制播放、暂停等操作 -->
        <!-- autoplay 属性自动播放视频 -->
        您的浏览器不支持视频播放
    </video>
    <div class="news-container">
        <div class="news">
            <h2 class="news-title">题库近况</h2>
            <a href="./index.jsp">
                新闻1:带动态的引导页面, 快来看看主界面的效果吧
            </a>
            <span class="news-date">2023-6-18</span><br/><br/>
            <a href="./problemset.jsp">
                新闻2:题库上线快来提交你在Online_Judge的第一道题吧!
            </a>
            <span class="news-date">2023-6-18</span><br/><br/>
            <a href="./PROBLEMSET/3.jsp">
                新闻3:旅行商问题, 模拟退火还是启发式合并
            </a>
            <span class="news-date">2023-6-18</span><br/><br/>
        </div>
        <div class="news">
            <h2 class="news-title">项目近况</h2>
            <a href="./ITEM/1.jsp">
                新闻1:管理面板上线,点击用户名即可进入
            </a>
            <span class="news-date">2023-6-18</span><br/><br/>
            <a href="./ITEM/3.jsp">新闻2:匹配系统上线</a>
            <span class="news-date">2023-6-18</span><br/><br/>
            <a href="./ITEM/3.jsp">新闻3:聊天室上线, 管理员全天在线</a>
            <span class="news-date">2023-6-18</span><br/><br/>
        </div>
    </div>
</div>
<!-- Content END -->

<%@ include file="footer.jsp" %>
</body>
</html>