window.addEventListener("DOMContentLoaded", () => {
  // 事件监听
  const textElement = document.getElementById("typing-text");   // 获取显示打字效果的文本元素
  const arrowElement = document.getElementById("arrow");        // 获取显示下拉箭头的元素

  const text =
    "欢迎来到Online_Judge, 这里是一个刷题和项目展示的网站, 按下箭头进入主页"; // 要打字的文本内容
  const typingSpeed = 150;                                                // 每个字母的打字速度（以毫秒为单位）
  const pauseTime = 500;                                                  // 指定时间后开始打字

  let index = 0;

  function type() {
    if (index < text.length) {
      // 如果未打字完所有字符
      textElement.textContent += text.charAt(index);  // 将当前字符添加到显示文本中
      index++;
      setTimeout(type, typingSpeed);                  // 延迟指定的时间后继续打字下一个字符
    } else {
      arrowElement.style.display = "block";           // 打字完成显示下拉箭头
      arrowElement.addEventListener("click", () => {
        // 添加点击事件监听器
        window.location.href = "../home.jsp";          // 在点击时跳转到指定的页面
      });
    }
  }
  setTimeout(type, pauseTime);          // 在指定的时间后开始打字
});

arrowElement.style.display = "block";   // 显示下拉箭头

function animateArrow() {
  // 箭头显示的函数
  const containerHeight = document.querySelector(".container").offsetHeight;  // 获取容器高度
  const arrowHeight = arrowElement.offsetHeight;                              // 获取箭头高度

  arrowElement.style.top = `${containerHeight - arrowHeight}px`;    // 将箭头定位到容器底部

  // 添加 CSS 动画类名，使箭头向下移动
  arrowElement.classList.add("animate-arrow");

  arrowElement.addEventListener("animationend", () => {
    arrowElement.style.animation = "none";                          // 移除动画效果
    arrowElement.style.top = `${containerHeight - arrowHeight}px`;  // 确保箭头位置固定在底部
  });
}

animateArrow(); // 执行箭头动画
