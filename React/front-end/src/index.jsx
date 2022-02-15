import React from 'react';
import ReactDOM from 'react-dom';
import Home from './Pages/Home';
import Destino from './Pages/Destino';
import Promocoes from './Pages/Promocoes';
import Cadastro from './Pages/Cadastro';
import Contato from './Pages/Contato';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'



ReactDOM.render(
  <React.StrictMode>
    <Router>
      <Routes>
        <Route path="/" exact element={<Home />}></Route>
        <Route path="/Destino" element={<Destino />}></Route>
        <Route path="/Promocoes" element={<Promocoes />}></Route>
        <Route path="/Contato" element={<Contato />}></Route>
        <Route path="/Cadastro" element={<Cadastro />}></Route>
      </Routes>
    </Router>
  </React.StrictMode>,
  document.getElementById('root')
);