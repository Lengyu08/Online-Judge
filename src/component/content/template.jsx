import React, { Component } from 'react';

class Template extends Component {
    state = {  } 
    render() { 
        return (
            <div className="card" style={{marginTop: "100px", fontSize: "20px", backgroundColor: "white"}}>
                <div className="card-body">
                    {this.props.children}
                </div>
            </div>
        );
    }
}
 
export default Template;
