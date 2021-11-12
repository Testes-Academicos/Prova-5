import "./App.css";
import Contactos from "./components/Contactos";
import { Link } from "react-router-dom";

function App() {
  return (
    <div className="container">
      <h1>Gestão de contacto</h1>
      <Link
        to={{ pathname: "/cadastrar"}}
        className="link" 
        id="btn-cadastro"
      >
        Cadastrar Contacto
      </Link>
      <Contactos />
    </div>
  );
}

export default App;
