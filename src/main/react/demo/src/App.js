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

      <Example1 ovogNer="Erdene" />

      <Example/>
    </div>
  );
}

function Example({ovogNer}) {
  return (
    <h1>Example, {ovogNer}</h1>
  );
}

function Example1(a) {
  return (
    <h1>
      Example, {a.ovogNer}
      <Example/>
    </h1>
  );
}

export default App;
