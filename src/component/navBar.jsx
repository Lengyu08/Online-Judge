import React, { Component } from 'react';
import { Link } from 'react-router-dom'; // 导入路由 {Link} 写成前端渲染

// 导航栏组件 https://v5.bootcss.com/docs/components/navbar/ 抽屉导航栏日间版
class NavBar extends Component {
    state = {  } 
    render() { 
        return(
            <nav className="navbar bg-body-tertiary fixed-top">
                <div className="container-fluid">
                    <Link className="navbar-brand" to="/">Online Judge</Link>
                    <button left="0" className="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
                        <span left="0" className="navbar-toggler-icon" ></span>
                    </button>
                    <div className="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                    <div className="offcanvas-header">
                        <h5 className="offcanvas-title" id="offcanvasNavbarLabel">菜单栏</h5>
                        <button type="button" className="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div className="offcanvas-body">
                        <ul className="navbar-nav justify-content-end flex-grow-1 pe-3">
                        <li className="nav-item">
                            <Link className="nav-link active" aria-current="page" to="/">首页</Link>
                        </li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                题库 
                            </a>
                            <ul className="dropdown-menu">
                            <li><Link className="dropdown-item" to="/algorithm">算法题库</Link></li>
                            <li><Link className="dropdown-item" to="/math">数学题库</Link></li>
                            <li><Link className='dropdown-item' to='/electric'>电气题库</Link></li>
                            <li>
                                <hr className="dropdown-divider"></hr>
                            </li>
                            <li><a className="dropdown-item" href="#">其他题目</a></li>
                            </ul>
                        </li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                项目展示
                            </a>
                            <ul className="dropdown-menu">
                            <li><a className="dropdown-item" href="#">数据结构</a></li>
                            <li><a className="dropdown-item" href="#">计算机组成原理</a></li>
                            <li><a className='dropdown-item' href='#'>操作系统</a></li>
                            <li><a className="dropdown-item" href="#">计算机网络</a></li>
                            <li><a className="dropdown-item" href="#">数据库</a></li>
                            <li><a className='dropdown-item' href='#'>编译原理</a></li>
                            <li><a className="dropdown-item" href="#">并行与分布式系统</a></li>
                            <li><a className='dropdown-item' href='#'>人工智能</a></li>
                            <li>
                                <hr className="dropdown-divider"></hr>
                            </li>
                            <li><a className="dropdown-item" href="#">其他项目</a></li>
                            </ul>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/login">登录</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/register">注册</Link>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="https://github.com/Lengyu08/Online-Judge" target="_blank">本项目所有的源代码</a>
                        </li>
                        </ul>
                        <form className="d-flex mt-3" role="search">
                        <input className="form-control me-2" type="search" placeholder="暂时不支持模糊搜索" aria-label="Search"></input>
                        <button className="btn btn-outline-success" type="submit">搜索</button>
                        </form>
                    </div>
                    </div>
                </div>
            </nav>
        );
    }
}
 
export default NavBar;