import React from "react";
import axios from "axios";
import { withRouter } from "react-router";

function LabelInput(props) {
  return (
    <div className="form-group">
      <label>{props.label}</label>
      <input
        type="TEXT"
        value={props.value}
        className="form-control"
        onChange={(e) => {
          if (props.atualizarTexto) {
            props.atualizarTexto(e.target.value);
          }
        }}
      />
    </div>
  );
}

class ContactoForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      id: props.location.id,
      contacto: {},
    };
  }

  state = {
    id: "",
    contacto: {
      id: "",
      nome: "liocroons",
      email: "liocroons01@prova.com",
      telefone: "",
    },
  };
  componentDidMount() {
    if (this.state.id !== undefined) {
      axios
        .get(`http://localhost:8080/contatos/${this.state.id}`, {
          responseType: "json",
        })
        .then((response) => {
          const nState = { ...this.state };
          //   nState.id = id;
          nState.id = response.data;
          this.setState(nState);
        });
    }
  }

  atualizarTexto(campo, txt) {
    const novoState = { ...this.state };

    novoState.contacto[campo] = txt;
    this.setState(novoState);
  }

  salvar() {
    const apiUrl = `http://localhost:8080/contatos/`;
    fetch(apiUrl, {
      method: "POST",
      headers: {
        Accept: "text/plain",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(this.state.contacto),
    }).then((response) => {
      console.log(response);
      this.componentDidMount();
      alert("contacto + " + this.state.contacto.nome + " cadastrado com sucesso");
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
      alert("contacto + " + this.state.contacto.nome + " cadastrado com sucesso");
    });
  }

  render() {
    const button = [];
    if (this.state.contacto) {
      button.push(
        <button
          id="btn"
          onClick={() => {
            this.salvar();
            this.props.history.push("/");
          }}
        >
          Salvar
        </button>
      );
    } else {
      button.push(
        <button
          id="btn"
          onClick={() => {
            this.editar();
            this.props.history.push("/");
          }}
        >
          Editar
        </button>
      );
    }

    return (
      <div className="form-contacto">
        <h2>Cadastro de contacto</h2>
        <LabelInput
          label="NOME:"
          corFundo="#DDDD00"
          value={this.state.contacto.nome}
          atualizarTexto={(txt) => this.atualizarTexto("nome", txt)}
        />
        <LabelInput
          label="EMAIL:"
          corFundo="#DDDD00"
          value={this.state.contacto.email}
          atualizarTexto={(txt) => this.atualizarTexto("email", txt)}
        />
        <LabelInput
          label="TELEFONE:"
          corFundo="#DDDD00"
          value={this.state.contacto.telefone}
          atualizarTexto={(txt) => this.atualizarTexto("telefone", txt)}
        />
        {button}
      </div>
    );
  }
}



export default withRouter(ContactoForm);
