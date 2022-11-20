package com.sistema.pelis.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.pelis.model.Serie;
public interface SerieReporitory extends JpaRepository<Serie, Integer>{

	
}
