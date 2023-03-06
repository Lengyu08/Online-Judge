import React, { Component } from "react";
import { Link } from "react-router-dom";
import { Player } from "video-react";
import "video-react/dist/video-react.css";
import "./css/home.css";
import "./css/news.css";

import Chart from "chart.js/auto";

class Home extends Component {
  chartRef = React.createRef();

  componentDidMount() {
    const chartCanvas = this.chartRef.current.getContext("2d");
    new Chart(chartCanvas, {
      type: "line",
      data: {
        labels: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
        datasets: [
          {
            label: "刷题难度评分",
            data: [1500, 1700, 500, 1344, 1222, 1111, 1321, 1222, 1223, 1444, 2500, 1555],
            borderColor: "#3e95cd",
            fill: true
          }
        ]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        },
        title: {
          display: true,
          text: ''
        }
      }
    });
  }

  render() {
    return (
      <div>
        <div className="container">
          <h2>Hello world! 点击右上角开始今天的刷题</h2>
        </div>

        <Player>
          <source src="video/winner.mp4"></source>
        </Player>
        <div class="news_con">
          <div class="news_l">
            <h3 class="news_title">新闻板块</h3>
            <ul class="news_list">
              <li>
                <a href="#">蓝桥杯将于4月份开赛</a>
                <span>1998-09-15</span>
              </li>
              <li>
                <a href="#">美国队ACM夺冠</a>
                <span>1998-09-15</span>
              </li>
              <li>
                <a href="#">新闻联播开播</a>
                <span>1998-09-15</span>
              </li>
              <li>
                <a href="#">学校周年庆</a>
                <span>1998-09-15</span>
              </li>
            </ul>
          </div>
          <div class="news_l">
            <h3 class="news_title">新题上线</h3>
            <ul class="news_list">
              <li>
                <a href="https://www.luogu.com.cn/problem/P1001">A+B problem</a>
                <span>1998-09-15</span>
              </li>
              <li>
                <Link href="/2">斐波那契数列</Link>
                <span>1998-09-15</span>
              </li>
              <li>
                <a href="#">01背包</a>
                <span>1998-09-15</span>
              </li>
            </ul>
          </div>
        </div>
        <div>
        <canvas ref={this.chartRef}></canvas>
        </div>

      </div>
    );
  }
}

export default Home

