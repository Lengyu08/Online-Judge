import React, { Component } from "react";
import "./css/blog_login.css";

class Login extends Component {
  state = {};
  render() {
    return (
      <div class="login-container">
        <div class="login-dialog">
          <h3>登录</h3>
          <div class="row1">
            <span>用户名</span>
            <input type="text" id="username" />
          </div>
          <div class="row1">
            <span>密码</span>
            <input type="password" id="password" />
          </div>
          <div class="row2">
            <input type="button" value="提交" id="submit" />
          </div>
        </div>
      </div>
    );
  }
}

export default Login;
