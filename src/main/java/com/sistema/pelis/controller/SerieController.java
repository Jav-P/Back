package com.sistema.pelis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.pelis.model.Serie;
import com.sistema.pelis.repository.SerieReporitory;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class SerieController {

	@Autowired
	private SerieReporitory repository;
	
	@GetMapping("/series")
	public List<Serie> listaSeries(){		
		return repository.findAll(); 
	}
	
	@PostMapping("/addS")	
	public Serie guardarSerie(@RequestBody Serie serie) {
		return repository.save(serie);		
	}

	@DeleteMapping("/deleteS/{id}")
	public void eliminarS(@PathVariable Integer id){
		repository.deleteById(id);
	}
	
}
