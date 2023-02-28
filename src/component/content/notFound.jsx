import React, { Component } from 'react';
import Template from './template';

class NotFound extends Component {
    state = {  } 
    render() { 
        return (
            <Template>
                对不起页面不见了, 如果你确定页面存在请联系管理员
            </Template>
        );
    }
}
 
export default NotFound;