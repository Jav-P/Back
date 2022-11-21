package com.sistema.pelis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.pelis.model.Pelicula;
import com.sistema.pelis.model.Persona;
import com.sistema.pelis.repository.PeliculaReporitory;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class PeliculaController {

	@Autowired
	private PeliculaReporitory repository;
	
	@GetMapping("/peliculas")
	public List<Pelicula> listaPeli(){		
		return repository.findAll(); 
	}
	
	@PostMapping("/add")	
	public Pelicula guardarPeli(@RequestBody Pelicula peli) {
		return repository.save(peli);		
	}
	@PutMapping("/comprarPeli/{id}")	
	public ResponseEntity<Pelicula> ComprarPeli(@PathVariable Integer id) {
		Pelicula peli = repository.findById(id).orElseThrow();
		peli.setTransacciones(peli.getTransacciones()+1);
		
		Pelicula actualizado = repository.save(peli);  
		return ResponseEntity.ok(peli);
	}
	@GetMapping("/peliculas/{id}")
	public ResponseEntity<Pelicula> peliId(@PathVariable Integer id ){
		Pelicula peli = repository.findById(id)
				.orElseThrow();
		return ResponseEntity.ok(peli);
	}
	@DeleteMapping("/delete/{id}")
	public void eliminar(@PathVariable Integer id){
		repository.deleteById(id);
	}
	
}
