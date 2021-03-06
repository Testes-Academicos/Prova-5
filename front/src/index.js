import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import ContactoForm from "./components/ContactoForm";
import Editar from "./components/Editar";

ReactDOM.render(
  <BrowserRouter>
    {/* <App /> */}
    <Switch>
      <Route path="/" exact={true} component={App} />
      <Route path="/cadastrar" component={ContactoForm} />
      <Route path="/cadastrar/:id" component={ContactoForm} />
      <Route path="/editar/:id" component={Editar} />
    </Switch>
  </BrowserRouter>,
  document.getElementById("root")
);
reportWebVitals();
