package com.br.uniamerica.repositories;

import java.util.Optional;

import com.br.uniamerica.models.Contacto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {

    Optional<Contacto> findById(Long id);
    
}
