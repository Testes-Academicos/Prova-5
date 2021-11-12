package com.br.uniamerica.services;

import com.br.uniamerica.controllers.dtos.ContactoDto;
import com.br.uniamerica.controllers.forms.ContactoForm;
import com.br.uniamerica.repositories.ContactoRepository;
import com.br.uniamerica.models.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class ContactoService {
    @Autowired
    ContactoRepository contactoRepository;

    public ResponseEntity<Page<ContactoDto>> list(Pageable pagination) {
        Page<Contacto> books = contactoRepository.findAll(pagination);
        return ResponseEntity.ok().body(ContactoDto.converter(books));
    }

    public ResponseEntity<ContactoDto> post(ContactoForm form, UriComponentsBuilder uriBuilder) {
        Contacto contacto = form.converter();
        contactoRepository.save(contacto);

        URI uri = uriBuilder.path("/contactos/{id}").buildAndExpand(contacto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ContactoDto(contacto));
    }

    public ResponseEntity<ContactoDto> detalhar(Long id) {
        Optional<Contacto> contacto = contactoRepository.findById(id);
        if (contacto.isPresent()) {
            return ResponseEntity.ok(new ContactoDto(contacto.get()));
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ContactoDto> update(Long id, ContactoForm form) {
        Optional<Contacto> optional = contactoRepository.findById(id);
        if (optional.isPresent()) {
            Contacto contacto = form.atualizar(id, contactoRepository);
            return ResponseEntity.ok(new ContactoDto(contacto));
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> remover(Long id) {
        Optional<Contacto> optional = contactoRepository.findById(id);
        if (optional.isPresent()) {
            contactoRepository.deleteById(optional.get().getId());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
