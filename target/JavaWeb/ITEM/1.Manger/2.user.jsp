<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@page import="Manger.UserMailBox" %>

<%!
  UserMailBox mail_box = new UserMailBox();
%>

<%
  String question = request.getParameter("question");
  String question_type = request.getParameter("question_type");
  String opt = request.getParameter("opt");
  System.out.println("question: " + question + " question_type: " + question_type + " opt: " + opt);
  if (opt != null && !opt.isEmpty()) {
    if (opt.equals("raise_question")) {
      mail_box.raiseQuestion(loggedInUsername, question_type, question);
    } else if (opt.equals("clear_mail")) {
      mail_box.clearMail(loggedInUsername);
    }
  }
  mail_box.queryList(loggedInUsername);
%>

<div class="container mt-5">
  <h2 style="margin-right:100px;font-weight: bolder; ">用户列表</h2>
  <br/><br/>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">处理人</th>
      <th scope="col">回复内容</th>
      <th scope="col">处理时间</th>
    </tr>
    </thead>
    <tbody>
    <% for (int i = 0; i < mail_box.getMessageListSize(); i ++) { %>
    <tr>
      <th scope="row"><%=mail_box.getMessageAdminName(i)%></th>
      <td><%=mail_box.getMessageContent(i)%></td>
      <td><%=mail_box.getMessageTime(i)%></td>
    </tr>
    <% } %>
    </tbody>
  </table>
</div>
<br/><br/><br/>

<div class="input-group">
  <span class="input-group-text">提出问题</span>
  <input type="text" aria-label="password" class="form-control" id="question" name="question">
  <select class="form-select" aria-label="Default select example" id="questionType" name="questionType">
    <option selected disabled hidden>选择问题的类型</option>
    <option value="problem_set">题目问题</option>
    <option value="item">项目问题</option>
    <option value="other">其他</option>
  </select>
  <button class="btn btn-outline-secondary" type="button" onclick="raise_question()">提出问题</button>
  <button class="btn btn-outline-secondary" type="button" onclick="clear_mail()">清空邮箱</button>
</div>

<script>
  function raise_question() {
    let question = document.getElementById("question").value;
    let question_type = document.getElementById("questionType").value;
    let opt = "raise_question";
    sublime_handle(question, question_type, opt);
  }

  function clear_mail() {
    let opt = "clear_mail";
    sublime_handle("", "", opt);
  }

  function sublime_handle(question, question_type, opt) {
    // Create a form element
    let form = document.createElement('form');
    form.method = 'post';
    form.action = '/ITEM/1.jsp';     // Set the action attribute to the current JSP page URL

    let questionInput = document.createElement('input');
    questionInput.type = 'hidden';
    questionInput.name = 'question';
    questionInput.value = question;
    form.appendChild(questionInput);

    let questionType = document.createElement('input');
    questionType.type = 'hidden';
    questionType.name = 'question_type';
    questionType.value = question_type;
    form.appendChild(questionType);

    let optInput = document.createElement('input');
    optInput.type = 'hidden';
    optInput.name = 'opt';
    optInput.value = opt;
    form.appendChild(optInput);

    // Append the form to the document body
    document.body.appendChild(form);

    // Submit the form
    form.submit();

  }
</script>
