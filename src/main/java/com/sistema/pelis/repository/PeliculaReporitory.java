package com.sistema.pelis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.pelis.model.Pelicula;
import com.sistema.pelis.model.Serie;

public interface PeliculaReporitory extends JpaRepository<Pelicula, Integer>{

	List<Pelicula> findBySerie(Serie serie);
}
