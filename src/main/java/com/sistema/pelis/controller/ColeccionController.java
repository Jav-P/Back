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

import com.sistema.pelis.model.Coleccion;
import com.sistema.pelis.repository.ColeccionReporitory;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class ColeccionController {

	@Autowired
	private ColeccionReporitory repository;
	
	@GetMapping("/colecciones")
	public List<Coleccion> listaColecciones(){		
		return repository.findAll(); 
	}
	
	@PostMapping("/addCo")	
	public Coleccion guardarColeccion(@RequestBody Coleccion coleccion) {
		return repository.save(coleccion);		
	}

	@DeleteMapping("/deleteCo/{id}")
	public void eliminarCo(@PathVariable Integer id){
		repository.deleteById(id);
	}
	
}
