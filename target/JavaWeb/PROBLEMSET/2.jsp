<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@include file="template_header.jsp"%>

<!-- Problem Start -->
<% session.setAttribute("problemId", "2");%>
<br/>
<p id="problem_title">2.迷宫问题</p>
<p id="time_limit">time limit : 1s</p>
<p id="memory_limit">mermory limit : 256MB</p>
<p id="input_method">input : standard input</p>
<p id="output_method">output : standard output</p>
<p id="problem_description">
  <span class="p_title">问题描述</span><br/>
  <span>
    给定一个 n × m 的二维整数数组，用来表示一个迷宫，数组中只包含 0 或 1, 其中 0 表示可以走的路, 1 表示不可通过的墙壁
    最初，有一个人位于左上角 (1,1) 处, 已知该人每次可以向上、下、左、右任意一个方向移动一个位置。
    请问，该人从左上角移动至右下角 (n,m) 处, 至少需要移动多少次
  </span><br/><br/>

  <span class="p_title">输入描述</span><br/>
  <span>
    第一行包含两个整数 n 和 m 接下来 n 行，每行包含 m 个整数 (0 或 1), 表示完整的二维数组迷宫
  </span><br/><br/>

  <span class="p_title">输出描述</span><br/>
  <span>输出一个整数, 表示从左上角移动至右下角的最少移动次数</span><br/><br/>

  <span class="p_title">输入样例</span><br/>
  <span class="mb-3">
      <input type="text" class="form-control" value="5 5" readonly><br/>
      <input type="text" class="form-control" value="0 1 0 0 0" readonly><br/>
      <input type="text" class="form-control" value="0 1 0 1 0" readonly><br/>
      <input type="text" class="form-control" value="0 0 0 0 0" readonly><br/>
      <input type="text" class="form-control" value="0 1 1 1 0" readonly><br/>
      <input type="text" class="form-control" value="0 0 0 1 0" readonly><br/>
  </span><br/><br/>

  <span class="p_title">输出样例</span><br/>
  <span class="mb-3">
      <input type="text" class="form-control" id="CopyOutput" value="8" readonly>
    </span><br/><br/>

  <span class="p_title">范围</span><br/>
  <span><span class="math-expression">1\leq n, m \leq 100</span></span><br/><br/>
</p>
<!-- Problem End -->

<%@ include file="template_footer.jsp"%>
