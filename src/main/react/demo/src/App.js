import React from 'react';
import logo from './logo.svg';
import './App.css';

var user = {
  firsName: 'Bold',
  lastName: 'Tuguldur',
  age: 17,
  married: true
}

function App() {
  
  return (
    <div className="App">

      Hello React {user.firsName}, {user.lastName}


      <Example ovogNer="Bold" nas="17"/>

      <Example ovogNer="Sarnai----"/>

      <Example/>
    </div>
  );
}

const h1Style = {
  fontSize: '16px',
  color: 'green'
}

function Example({ovogNer}) {
  return (
    <h1 style={h1Style}>Example, {ovogNer}</h1>
  );
}

function Example1({ovogNer}) {
  return (
    <h1 style={{fontSize: 18}}>Example, {ovogNer}</h1>
  );
}

export default App;
