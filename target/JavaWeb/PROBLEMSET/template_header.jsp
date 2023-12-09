<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@ include file="/header.jsp" %>

<%
  String ans = (String)request.getAttribute("ans");
  String roomID = (String)session.getAttribute("roomID");
  String currentURL = request.getRequestURL().toString();
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title></title>
  <link rel="stylesheet" type="text/css" href="../CSS/navbar.css"/>
  <link rel="stylesheet" type="text/css" href="../CSS/content.css"/>
  <link rel="stylesheet" type="text/css" href="../CSS/footer.css"/>
  <!-- 引入 CodeMirror 样式文件 5.63.1 -->
  <link rel="stylesheet" href="../LIB/Code-Mirror/codemirror.min.css">
  <!-- 引入 CodeMirror 主题 -->
  <link rel="stylesheet" href="../LIB/Code-Mirror/dracula.min.css">
  <!-- 引入 Katex -->
  <link rel="stylesheet" href="/LIB/Katex/katex.min.css">
  <!-- 引入 Bootstrap 样式文件 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <style>
      /* 替换为适当的字体 */
      .CodeMirror {
          font-family: Consolas, monospace;
          font-size: 24px; /* 可根据需要调整字体大小 */
      }

      span {
          font-size: 20px;
      }

      .choose {
          background-color: #ffffff; /* 设置兴趣爱好下拉框的背景颜色为黑色 */
          color: #000000; /* 设置兴趣爱好下拉框的文字颜色为白色 */
          font-size: 18px; /* 设置兴趣爱好下拉框的文字大小为18像素 */
          border: 3px solid #000; /* 使用像素值加粗边框 */
          padding: 10px; /* 设置兴趣爱好下拉框的内边距为10像素 */
          width: 10%; /* 设置兴趣爱好下拉框宽度为父容器的50% */
          min-width: 120px;
      }

      .title {
          font-weight: bold;
          font-family: 黑体, serif;
      }

      option, .choose, .title {
          font-weight: bold;
      }

      .sublime_code {
          font-size: 24px;
          display: inline-block;
          padding: 10px 20px;
          border-radius: 20px;
          background-color: #b0acac;
          color: #020202;
          text-decoration: none;
          transition: background-color 0.3s;
          cursor: pointer;
      }

      .sublime_code:hover {
          background-color: #555555; /* Change the background color on hover */
          color: #ffffff;
      }

      p {
          font-family: 微软雅黑, serif;
          margin: 0.5% auto;
      }

      #problem_title {
          font-size:30px;
      }

      #problem_description {
          text-align: left;
          margin: 3% 8%;
      }

      .p_title {
          font-weight: bold;
          font-family: 黑体, serif;
          /*border: 3px solid black;*/
      }

      input {
          width: auto;
          border-width: 5px;
          font-size:18px;
          font-family: 黑体, serif;
      }
  </style>
</head>
<body>
<%@ include file="/navbar.jsp" %>

<!-- Content Start -->
<div class="content">