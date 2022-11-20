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

import com.sistema.pelis.model.Persona;
import com.sistema.pelis.repository.PersonaReporitory;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonaController {

	@Autowired
	private PersonaReporitory repository;
	
	@GetMapping("/personas")
	public List<Persona> listaPersonas(){		
		return repository.findAll();  
	}
	
	
	@PostMapping("/addP")	
	public Persona guardarPersona(@RequestBody Persona persona) {
		return repository.save(persona);		
	}
	@PutMapping("/AcPersona/{id}")	
	public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id) {
		Persona person = repository.findById(id).orElseThrow();
		person.setPuntos(person.getPuntos()+1);
		
		Persona actualizado = repository.save(person);  
		return ResponseEntity.ok(person);
	}
	
	@GetMapping("/personas/{id}")
	public ResponseEntity<Persona> personaId(@PathVariable Integer id ){
		Persona persona = repository.findById(id)
				.orElseThrow();
		return ResponseEntity.ok(persona);
	}
	
	@DeleteMapping("/deleteP/{id}")
	public void eliminarS(@PathVariable Integer id){
		repository.deleteById(id);
	}
	
}
