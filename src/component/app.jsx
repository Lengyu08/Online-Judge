import React, { Component } from 'react';
import NavBar from './navBar'; // 导航栏 
import Home from './content/home';
import Login from './content/login';
import Register from './content/register';
import NotFound from './content/notFound';
import Algorithm from './question/algorithm';
import { Route, Routes, Navigate } from 'react-router-dom'; // 路由


import Two from './question/content/2';

// 主方法
class APP extends Component {
    state = {  } 
    render() {
        return (
            <React.Fragment>
                <NavBar/> {/* 实现导航栏 */}
                <div className="container"> {/* container 响应式的调整布局 */}
                    <Routes>
                        <Route path="/" element={<Home />}/>
                        <Route path="/home" element={<Home />}/>
                        <Route path="/algorithm" element={<Algorithm />}/>

                        <Route path="/2" element={<Two />}/>

                        <Route path="/login" element={<Login />}/>
                        <Route path="/register" element={<Register />}/>
                        <Route path="/404" element={<NotFound />}/>
                        <Route path="*" element={ <Navigate replace to="/404" /> } />
                    </Routes>
                </div>

            </React.Fragment>
        );
    }
}
 
export default APP;