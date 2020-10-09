import React, { Component } from 'react';
import './Counter.css'

class Counter extends Component{

    constructor(){
        super();
        this.abc = 5;
        this.state = {
            counter : 0
        }
    }



    render(){
        return(
            <div className="counter">
           <button onClick={this.increment}>+1</button>
           <span className="count">{this.state.counter}</span>
            </div>
        )
    }
    
     increment = () =>  {
        this.setState({
            counter: this.state.counter + 1
        }
        );
    }
}



export default Counter;