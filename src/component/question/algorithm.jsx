import React, { Component } from "react";
import { Link } from "react-router-dom";
import Markdown from "./markdown";

class Algorithm extends Component {
  state = {};
  render() {
    return (
      <table className="table">
        <thead>
          <tr>
            <th scope="col">编号</th>
            <th scope="col">题目</th>
            <th scope="col">难度</th>
            <th scope="col">分类</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td><b><Link to="/math">1.A+B</Link></b></td>
            <td>入门</td>
            <td>测试问题</td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td><b><Link to="/math">2.斐波那契</Link></b></td>
            <td>入门</td>
            <td>动态规划-基础问题</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td><b><Link to="/math">3.01背包</Link></b></td>
            <td>普及-</td>
            <td>动态规划-背包问题</td>
          </tr>
        </tbody>
      </table>
    );
  }
}

export default Algorithm;
