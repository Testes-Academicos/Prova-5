import { render, fireEvent } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import ContactoForm from "../ContactoForm";
import axios from "axios";

const mockPerson = {
    nome: "lio",
    email: "liocroons@teste.com",
    telefone: "45984033369"
}

const MockContactoForm = () => {
    return {
        <BrowserRouter>
            <ContactoForm/>
        </BrowserRouter>  
    );
};

test ('shoul send to create and expect api is called'), async () => {
    render(<MockContactoForm/>)

    const nameElement = screen.getBy
}