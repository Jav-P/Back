package com.sistema.pelis.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.pelis.model.Coleccion;

public interface ColeccionReporitory extends JpaRepository<Coleccion, Integer>{

	
}
