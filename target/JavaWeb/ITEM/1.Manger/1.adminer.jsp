<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@page import="Manger.FeedBack" %>

<%!
  FeedBack feedBack = new FeedBack();
%>

<%
  String email_id = request.getParameter("email_id");
  String replay_email = request.getParameter("replay_email");
  String opt = request.getParameter("opt");
  System.out.println("email_id: " + email_id + " replay: " + replay_email + " " + opt);
  if (opt != null && !opt.isEmpty()) {
    if (opt.equals("replay")) {
      feedBack.refer_to_user(Integer.parseInt(email_id), loggedInUsername, replay_email);
    } else if (opt.equals("delete")) {
        System.out.println("进入删除界面");
      feedBack.delete_mail(Integer.parseInt(email_id));
    }
  }
  feedBack.queryList();
%>

<div class="container mt-5">
  <h2 style="margin-right:100px;font-weight: bolder; ">用户列表</h2>
  <br/><br/>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">反馈用户</th>
      <th scope="col">反馈类型</th>
      <th scope="col">反馈内容</th>
      <th scope="col">反馈时间</th>
    </tr>
    </thead>
    <tbody>
    <% for (int i = 0; i < feedBack.getMessageListSize(); i++) { %>
    <tr>
      <th scope="row"><%=feedBack.getMessageId(i)%></th>
      <td><%=feedBack.getMessageUsername(i)%></td>
      <td><%=feedBack.getMessageType(i)%></td>
      <td><%=feedBack.getMessageEmail(i)%></td>
      <td><%=feedBack.getMessageTime(i)%></td>
    </tr>
    <% } %>
    </tbody>
  </table>
</div>
<br/><br/><br/>

<div class="input-group">
  <span class="input-group-text">ID</span>
  <input type="text" aria-label="username" class="form-control" id="email_id" name="email_id">

  <span class="input-group-text">回复意见</span>
  <input type="text" aria-label="password" class="form-control" id="replay_email" name="replay_email">

  <button class="btn btn-outline-secondary" type="button" onclick="replay_mail()">回复意见</button>
  <button class="btn btn-outline-secondary" type="button" onclick="delete_mail()">删除信件</button>
</div>

<script>
  function replay_mail() {
    let email_id = document.getElementById("email_id").value;
    let replay_email = document.getElementById("replay_email").value;
    let opt = "replay";
    handleMessage(email_id, replay_email, opt);
  }

  function delete_mail() {
    let email_id = document.getElementById("email_id").value;
    let opt = "delete";
    handleMessage(email_id, "", opt);
  }

  function handleMessage(email_id, replay_email, opt) {
    // Create a form element
    let form = document.createElement('form');
    form.method = 'post';
    form.action = '/ITEM/1.jsp';     // Set the action attribute to the current JSP page URL

    let emailIDInput = document.createElement('input');
    emailIDInput.type = 'hidden';
    emailIDInput.name = 'email_id';
    emailIDInput.value = email_id;
    form.appendChild(emailIDInput);

    let replayInput = document.createElement('input');
    replayInput.type = 'hidden';
    replayInput.name = 'replay_email';
    replayInput.value = replay_email;
    form.appendChild(replayInput);

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

