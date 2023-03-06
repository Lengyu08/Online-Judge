import React, { Component } from "react";
import "../../content/css/comment.css";
import "../../content/css/blog_detail.css";
import "../../content/css/blog_login.css";
import "katex/dist/katex.min.css";
import TeX from "@matejmazur/react-katex";

class One extends Component {
  state = {};
  render() {
    return (
      <div className="container">
        <div className="blog-content">
          <h2>斐波那契数列</h2>
          <div class="date">时间:1s</div>
          <div class="detail">
            <p>
              兔子数列即斐波那契数列, 它的发明者是意大利数学家列昂纳多•斐波那契
              (Leonardo Fibonacci, 1170—1250). 1202年,
              他撰写了《算盘全书》(《Liber
              Abaci》)一书，该书是一部较全面的初等数学著作。
              书中系统地介绍了印度—阿拉伯数码及其演算法则，介绍了中国的"盈不足术";
              引入了负数, 并研究了一些简单的一次同余式组。
            </p>
            <p>
              第1个月, 小兔子①没有繁殖能力, 所以还是1个。
              第2个月, 小兔子①进入成熟期, 仍然是1个。
              第3个月, 兔子①生了1个小兔子②, 于是这个月共有1+1=2个兔子。
              第4个月, 兔子①又生了1个小兔子③. 因此共有1+2=3个兔子。
            </p>
            <p>
              <TeX>1~1~2~3~5~8</TeX>
            </p>
            <p>
              给定输入 <TeX>x</TeX>, 求这是斐波那契的第几个.
            </p>
            <p>输入</p>
            <p>3</p>
            <p>输出</p>
            <p>2</p>
            <div className="blog-button">
              <button type="button" class="btn btn-dark">
                提交
              </button>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default One;
