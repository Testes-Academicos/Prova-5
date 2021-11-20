import React from "react";
import axios from "axios";
import { Link } from "react-router-dom";

class Contactos extends React.Component {
  state = {
    contacto: {
      id: "",
      nome: "",
      email: "",
      telefone: "",
    },
    lista: [],
  };

  componentDidMount() {
    axios
      .get(`http://localhost:8080/contatos/`, {
        responseType: "json",
      })
      .then((response) => {
        const nState = { ...this.state };
        nState.lista = response.data;
        this.setState(nState);
      });
  }

  editar() {
    const apiUrl = `http://localhost:8080/contatos/${this.state.contacto.id}`;
    fetch(apiUrl, {
      method: "PUT",
      headers: {
        Accept: "text/plain",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(this.state.contacto),
    }).then((response) => {
      console.log(response);
      this.componentDidMount();
      alert("contacto + " + this.state.contacto.nome + " deletado com sucesso");
    });
  }

  excluir(contacto) {
    const apiUrl = `http://localhost:8080/contatos/${contacto.id}`;
    fetch(apiUrl, {
      method: "DELETE",
      headers: {
        Accept: "text/plain",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(this.state.alunoAtual),
    }).then((response) => {
      console.log(response.body);
      alert(
        "O contacto de \id: " +
          contacto.id +
          "\nome: " +
          contacto.nome +
          "\nfoi excluido com sucesso."
      );
      this.componentDidMount();
    });
  }

  render() {
    const lista = this.state.lista;
    const listaDisplay = [];
    const camposTabela = [];
    for (let i = 0; i < lista.length; i++) {
      listaDisplay.push(
        <tr key={lista[i].id}>
          <td>{lista[i].id}</td>

          <td>{lista[i].nome}</td>
          <td>{lista[i].email}</td>
          <td>{lista[i].telefone}</td>
          <td>
            <div id="td-buttons">
              <Link
                to={{ pathname: "/editar/"+  lista[i].id }}
                className="link"
              >
                Editar
              </Link>
              <button
                id="btn-excluir"
                onClick={() => {
                  this.excluir(lista[i]);
                }}
              >
                Excluir
              </button>
            </div>
          </td>
        </tr>
      );
    }

    if (lista[0] !== undefined) {
      Object.keys(lista[0]).forEach((campo) => {
        camposTabela.push(<th>{campo.toUpperCase()}</th>);
      });
      camposTabela.push(<th> </th>);
    }

    return (
      <div>
        <h2>Contactos</h2>
        <table className="table table-striped">
          <thead>
            <tr>{camposTabela}</tr>
          </thead>
          <tbody>{listaDisplay}</tbody>
        </table>
      </div>
    );
  }
}

export default Contactos;
