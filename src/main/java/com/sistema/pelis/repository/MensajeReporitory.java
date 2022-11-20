package com.sistema.pelis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.pelis.model.Mensaje;

public interface MensajeReporitory extends JpaRepository<Mensaje, Integer>{

}
