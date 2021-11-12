package com.br.uniamerica.controllers.dtos;

import com.br.uniamerica.models.Contacto;
import org.springframework.data.domain.Page;

public class ContactoDto {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public ContactoDto(Contacto contacto){
        this.id = contacto.getId();
        this.nome = contacto.getNome();
        this.email = contacto.getEmail();
        this.telefone = contacto.getTelefone();
    }

    public static Page<ContactoDto> converter(Page<Contacto> contactos) {
		return contactos.map(ContactoDto::new);
	}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    

    

}
