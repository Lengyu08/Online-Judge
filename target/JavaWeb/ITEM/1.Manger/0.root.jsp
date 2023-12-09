<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@page
    import="Manger.RootOpt"
%>

<%!
  RootOpt rootOpt = new RootOpt();
%>

<%
  String username = request.getParameter("username");
  String password = request.getParameter("password");
  String permission = request.getParameter("permission");
  String opt = request.getParameter("opt");
  int right_level = -1;
  if (Objects.equals(permission, "0")) right_level = 0;
  else if (Objects.equals(permission, "1")) right_level = 1;
  else if (Objects.equals(permission, "2")) right_level = 2;
  if (Objects.equals(opt, "add_user")) {
    rootOpt.addUser(username, password, right_level);
  } else if (Objects.equals(opt, "modify_user")) {
    rootOpt.modifyUser(username, password, right_level);
  } else if (Objects.equals(opt, "delete_user")) {
    rootOpt.deleteUser(username);
  }
  rootOpt.queryUserList();
%>

<div class="container mt-5">
  <h2 style="margin-right:100px;font-weight: bolder; ">用户列表</h2>
  <br/><br/>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">用户编号</th>
      <th scope="col">姓名</th>
      <th scope="col">密码</th>
      <th scope="col">权限等级</th>
    </tr>
    </thead>
    <tbody>
    <!-- User Data -->
    <% for (int i = 0; i < new RootOpt().getUserListSize(); i++) { %>
    <tr>
      <th scope="row"><%=new RootOpt().getUserId(i)%></th>
      <td><%=new RootOpt().getUserName(i)%></td>
      <td><%=new RootOpt().getUserPassword(i)%></td>
      <td><%=new RootOpt().getUserLevel(i)%></td>
    </tr>
    <% } %>
    </tbody>
  </table>
</div>
<br/><br/><br/>

<div class="input-group">
  <span class="input-group-text">用户名</span>
  <input type="text" aria-label="username" class="form-control" id="usernameInput" name="username">

  <span class="input-group-text">密码</span>
  <input type="password" aria-label="password" class="form-control" id="passwordInput" name="password">

  <span class="input-group-text">权限</span>
  <select class="form-select" aria-label="Default select example" id="permissionSelect" name="right_level">
    <option selected disabled hidden>选择用户的权限</option>
    <option value="0">超级用户</option>
    <option value="1">管理员</option>
    <option value="2">普通用户</option>
  </select>

  <button class="btn btn-outline-secondary" type="button" onclick="add_user()">添加用户</button>
  <button class="btn btn-outline-secondary" type="button" onclick="modify_user()">修改用户</button>
  <button class="btn btn-outline-secondary" type="button" onclick="delete_user()">删除用户</button>
</div>

<!-- Add your JavaScript script -->
<script>
  function add_user() {
    let username = document.getElementById('usernameInput').value;
    let password = document.getElementById('passwordInput').value;
    let permission = document.getElementById('permissionSelect').value;
    let opt = "add_user";
    sublime_message(username, password, permission, opt);
  }

  function modify_user() {
    let username = document.getElementById('usernameInput').value;
    let password = document.getElementById('passwordInput').value;
    let permission = document.getElementById('permissionSelect').value;
    let opt = "modify_user";
    sublime_message(username, password, permission, opt);
  }

  function delete_user() {
    // Add your login logic here
    let username = document.getElementById('usernameInput').value;
    let opt = "delete_user";
    sublime_message(username, "", "", opt);
  }

  function sublime_message(username, password, permission, opt) {
    // Create a form element
    let form = document.createElement('form');
    form.method = 'post'; // Use 'post' method to send sensitive data like passwords
    form.action = '/ITEM/1.jsp';     // Set the action attribute to the current JSP page URL

    // Create input elements for each parameter
    let usernameInput = document.createElement('input');
    usernameInput.type = 'hidden';
    usernameInput.name = 'username';
    usernameInput.value = username;
    form.appendChild(usernameInput);

    let passwordInput = document.createElement('input');
    passwordInput.type = 'hidden';
    passwordInput.name = 'password';
    passwordInput.value = password;
    form.appendChild(passwordInput);

    let permissionInput = document.createElement('input');
    permissionInput.type = 'hidden';
    permissionInput.name = 'permission';
    permissionInput.value = permission;
    form.appendChild(permissionInput);

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
