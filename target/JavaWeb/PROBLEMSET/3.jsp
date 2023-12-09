<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@include file="template_header.jsp"%>

<!-- Problem Start -->
<% session.setAttribute("problemId", "3");%>
<br/>
<p id="problem_title">3.旅行商问题</p>
<p id="time_limit">time limit : 1s</p>
<p id="memory_limit">mermory limit : 256MB</p>
<p id="input_method">input : standard input</p>
<p id="output_method">output : standard output</p>
<p id="problem_description">
  <span class="p_title">问题描述</span><br/>
  <span>
    “旅行商问题”是这样一个问题：“给出一个城市列表以及每对城市之间的距离，访问每个城市并返回原城市的最短路线是什么？”
    这是组合优化中的一个 NP 难题，在运筹学和理论计算机科学中十分重要。
    在此问题中，请你从给定的路径列表中找到最接近旅行商问题的解的路径。
  </span><br/><br/>

  <span class="p_title">输入描述</span><br/>
  <span>输入两个整数.</span><br/><br/>

  <span class="p_title">输出描述</span><br/>
  <span>
  </span><br/><br/>

  <span class="p_title">输入样例</span><br/>
  <span class="mb-3">
      <input type="text" class="form-control" id="CopyInput" value="1 2" readonly>
    </span><br/><br/>

  <span class="p_title">输出样例</span><br/>
  <span class="mb-3">
      <input type="text" class="form-control" id="CopyOutput" value="3" readonly>
    </span><br/><br/>

  <span class="p_title">范围</span><br/>
  <span><span class="math-expression">1\leq a, b \leq 10^9</span></span><br/><br/>
</p>
<!-- Problem End -->

<%@ include file="template_footer.jsp"%>
