package com.br.uniamerica.controllers.forms;

import java.util.Optional;

import com.br.uniamerica.models.Contacto;
import com.br.uniamerica.repositories.ContactoRepository;

public class ContactoForm {


    private String nome;
    private String email;
    private String telefone;
    

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Contacto converter() {
        return new Contacto(this.nome,this.email,this.telefone);
    }

    public Contacto atualizar(Long id, ContactoRepository contactoRepository) {
		Optional<Contacto> contacto = contactoRepository.findById(id);
        if(contacto.isPresent()){
            contacto.get().setNome(this.nome);
            contacto.get().setEmail(this.email);
            contacto.get().setTelefone(this.telefone);
            return contacto.get();
        }
        return null;
		
	}
    
}
