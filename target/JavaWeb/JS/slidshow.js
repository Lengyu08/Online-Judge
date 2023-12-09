// 获取所有的图片元素和按钮元素
let slides = document.querySelectorAll("#slideshow img");
let buttons = document.querySelectorAll(".slideshow-sub");

// 定义一个变量来存储当前显示的图片索引
let index = 0;

// 定义一个变量来存储轮播的定时器
let timer = null;

// 定义一个变量来存储鼠标按下的时间戳
let mouseDownTimestamp = 0;

// 定义一个函数来显示指定索引的图片, 手动添加 hover 的效果
function showSlide(n) {
  // 隐藏所有的图片和移除所有按钮的hover效果
  for (let i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
    buttons[i].style.backgroundColor = "white";
    buttons[i].style.color = "black";
  }
  // 显示指定索引的图片，并为对应的按钮添加hover效果
  slides[(n + 0) % 3].style.display = "block"; // 偏移公式 (n + 偏移量) % 图片数量
  buttons[n].style.backgroundColor = "black";
  buttons[n].style.color = "white";
}

// 定义一个函数来启动轮播
function startSlideshow() {
  // 如果已经有定时器，先清除它
  if (timer) {
    clearInterval(timer);
  }
  // 设置一个新的定时器，每隔3秒调用一次showSlide函数，并更新索引值
  timer = setInterval(function () {
    index++;
    // 如果索引超过了图片数量，重置为0
    if (index >= slides.length) {
      index = 0;
    }
    showSlide(index);
  }, 1000);
}

// 定义一个函数来停止轮播
function stopSlideshow() {
  // 如果有定时器，清除它
  if (timer) {
    clearInterval(timer);
    timer = null;
  }
}

// main 函数
console.log("slideshow.js loaded");

// 调用showSlide函数，显示第一张图片
showSlide(index);

// 调用startSlideshow函数，启动轮播
startSlideshow();

// 给每个按钮添加点击事件监听器，当点击时，停止轮播并切换到对应的图片
for (let i = 0; i < buttons.length; i++) {
  buttons[i].addEventListener("click", function () {
    stopSlideshow();
    showSlide(i);
    index = i; // 记录下停下的位置
  });
}

// 给每个按钮添加点击事件监听器，当点击时，停止轮播并切换到对应的图片
for (let i = 0; i < buttons.length; i++) {
  buttons[i].addEventListener("click", function () {
    stopSlideshow();
    showSlide(i);
    // 设置一个延时函数，在3秒后重新启动轮播
    setTimeout(function () {
      startSlideshow();
    }, 1500);
  });
}
