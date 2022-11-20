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

import com.sistema.pelis.model.Genero;
import com.sistema.pelis.repository.GeneroReporitory;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class GeneroController {

	@Autowired
	private GeneroReporitory repository;
	
	@GetMapping("/generos")
	public List<Genero> listaGenero(){		
		return repository.findAll(); 
	}
	
	@PostMapping("/addG")	
	public Genero guardarGenero(@RequestBody Genero genero) {
		return repository.save(genero);		
	}
	
	@DeleteMapping("/deleteG/{id}")
	public void eliminarI(@PathVariable Integer id){
		repository.deleteById(id);
	}
}
