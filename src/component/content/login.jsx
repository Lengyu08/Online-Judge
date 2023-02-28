import React, { Component } from "react";
import "./css/login.css"

class Login extends Component {
  state = {};
  render() {
    return (
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-2"></div>
            <div class="col-lg-6 col-md-8 login-box">
                <div class="col-lg-12 login-title">
                    用户登录
                </div>

                <div class="col-lg-12 login-form">
                    <div class="col-lg-12 login-form">
                        <form>
                            <div class="form-group">
                                <label class="form-control-label">用户名</label>
                                <input type="text" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label class="form-control-label">密码</label>
                                <input type="password" class="form-control" />
                            </div>

                            <div class="col-lg-12 loginbttm">
                                <div class="col-lg-6 login-btm login-text">
                                </div>
                                <div class="col-lg-6 login-btm login-button">
                                    <button type="submit" class="btn btn-outline-primary">登录</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-3 col-md-2"></div>
            </div>
        </div>
        </div>
    );
  }
}

export default Login;
