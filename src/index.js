import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import 'bootstrap/dist/css/bootstrap.css'; // 响应式布局
import 'bootstrap/dist/js/bootstrap.bundle' // 捆绑启动器
import { BrowserRouter } from 'react-router-dom'; // 路由
import APP from './component/app';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <APP />
  </BrowserRouter>
);