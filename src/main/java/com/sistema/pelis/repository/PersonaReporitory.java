package com.sistema.pelis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.pelis.model.Persona;

public interface PersonaReporitory extends JpaRepository<Persona, Integer>{

}
