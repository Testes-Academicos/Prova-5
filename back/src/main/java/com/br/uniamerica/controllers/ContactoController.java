package com.br.uniamerica.controllers;

import javax.transaction.Transactional;

import com.br.uniamerica.controllers.dtos.ContactoDto;
import com.br.uniamerica.controllers.forms.ContactoForm;
import com.br.uniamerica.repositories.ContactoRepository;

import com.br.uniamerica.services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin
@RestController
@RequestMapping("/contactos")
public class ContactoController {

    @Autowired
    ContactoRepository contactoRepository;

    @Autowired
    ContactoService service;

    @GetMapping
    public ResponseEntity<Page<ContactoDto>> list(Pageable pagination) {
       return service.list(pagination);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ContactoDto> post(@RequestBody ContactoForm form, UriComponentsBuilder uriBuilder) {
        return service.post(form, uriBuilder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoDto> detalhar(@PathVariable Long id) {
        return service.detalhar(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ContactoDto> update(@PathVariable Long id, @RequestBody ContactoForm form) {
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        return service.remover(id);
    }

}
