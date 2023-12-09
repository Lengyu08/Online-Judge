<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<!-- https://www.iconfont.cn/?spm=a313x.7781069.1998910419.d4d0a486a 图标的下载地址, 还有一个付费的我免费额度用完了就忘了 -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Index</title>
    <style type="text/css">
      body {
        background-image: url("./STATIC-RESOURCES/IMAGE/background/background.jpg"); /* 设置背景图片路径 */
        background-position: center; /* 将背景图片在容器中居中 */
        background-repeat: no-repeat; /* 防止背景图片重复显示 */
        background-size: 100% 100%; /* 将背景图片拉伸以铺满容器 */
        background-attachment: fixed; /* 固定背景图片，不随页面滚动而滚动 */
        height: 100vh; /* 设置容器的高度为视口的高度 */
        margin: 0; /* 移除默认的边距 */
      }
      .container {
        display: flex; /* 使用 Flexbox 布局 */
        flex-direction: column; /* 垂直排列子元素 */
        justify-content: center; /* 水平居中子元素 */
        align-items: center; /* 垂直居中子元素 */
        height: 100vh; /* 设置容器的高度为视口的高度 */
      }

      #typing-text {
        font-family: 黑体, serif;
        font-size: 36px; /* 设置字体大小为 24 像素 */
        text-align: center; /* 文本水平居中对齐 */
      }

      #arrow {
        width: 40px; /* 设置宽度为 40 像素 */
        height: 40px; /* 设置高度为 40 像素 */
        background-image: url("./STATIC-RESOURCES/IMAGE/icon/arrow.svg"); /* 使用指定的箭头图像作为背景 */
        background-size: cover; /* 自动缩放背景图像以覆盖整个元素 */
        margin-top: 20px; /* 在顶部留出 20 像素的空白 */
        cursor: pointer; /* 鼠标悬停时显示指针光标 */
        position: relative; /* 设置为相对定位, 这里是实现动画的关键 */
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1 id="typing-text"></h1>
      <!-- 用于显示打字效果的文本 -->
      <div id="arrow"></div>
      <!-- 用于显示下拉箭头的元素 -->
    </div>
    <script src="./JS/index.js"></script>
  </body>
</html>
