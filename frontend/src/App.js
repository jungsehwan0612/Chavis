import React, { Component } from 'react';
import Dashboard from './dashboard/Dashboard'
import axios from 'axios';

const http = axios.create({
  baseURL: 'http://127.0.0.1:8080',
  headers: {
    'content-type': 'application/json;charset=utf-8'
  },
  withCredentials: true
});

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      isLogin: false,
      bodyshop_id: '',
      bodyshop_pw: ''
    }
  }

  render() {
    return (
      <div>
        <Dashboard/>
        {this.props.children}
      </div>
    );
  }

}


function App() {


  return (
    <div className="App">
      <Dashboard />
    </div>
  );
}

export default App;

