<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@include file="template_header.jsp"%>

  <!-- Problem Start -->
  <% session.setAttribute("problemId", "1");%>
  <br/>
  <p id="problem_title">1.A+B Problem</p>
  <p id="time_limit">time limit : 1s</p>
  <p id="memory_limit">mermory limit : 256MB</p>
  <p id="input_method">input : standard input</p>
  <p id="output_method">output : standard output</p>
  <p id="problem_description">
    <span class="p_title">问题描述</span><br/>
    <span>计算 a + b 的和.</span><br/><br/>

    <span class="p_title">输入描述</span><br/>
    <span>输入两个整数.</span><br/><br/>

    <span class="p_title">输出描述</span><br/>
    <span>输出一个整数 a + b 的和</span><br/><br/>

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
