import React, { Component } from 'react';
import './App.css';
import Header from './Header';
import Counter from './Counter/Counter'
 
class App extends Component {
  render() {
    return (
      <div className="App">
        <Counter/>
      </div>
    );
  }
}



class LearningComponents extends Component{
  render(){
    return(
      <div className="LearnigComponents"></div>
    )
  }
}


export default App;
