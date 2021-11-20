/** import { render, screen, fireEvent } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import axios from "axios"

import ContactoForm from "../ContactoForm";

const mockForm = {
    id: "",
    nome: "liocroons",
    email: "liocroons01@prova.com",
    telefone: "45984033369",
}

const MockContactoForm = () => {
    return (
        <BrowserRouter>
            <ContactoForm />
        
        </BrowserRouter>
        
    );
};

test("deve enviar um contato para criar e esperar que a API seja chamada"), async () =>{
    axios.post.mockImplementation(()=> Promise.resolve(mockForm));
    render(<MockContactoForm/>);

    const nomeElement = screen.getByLabelText("nome");
    const emailElement = screen.getByLabelText("endereço eletronico");
    const telefoneElement = screen.getByRole("button");
}

fireEvent.change(nomeElement, {target:{value: "lio"}});
fireEvent.change(emailElement, {target:{value: "lio@prova"}});
fireEvent.change(telefoneElement, {target:{value: "849033369"}});
fireEvent.click(button);

expect(nomeElement).toBeInTheDocument();
expect(emailElement).toBeInTheDocument();
expect(telefoneElement).toBeInTheDocument();

expect(axios.post).toBeCalled(); */
