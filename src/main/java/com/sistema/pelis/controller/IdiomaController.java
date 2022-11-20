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

import com.sistema.pelis.model.Idiomas;
import com.sistema.pelis.repository.IdiomaReporitory;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class IdiomaController {

	@Autowired
	private IdiomaReporitory repository;
	
	@GetMapping("/idiomas")
	public List<Idiomas> listaIdiomas(){		
		return repository.findAll(); 
	}
	
	@PostMapping("/addI")	
	public Idiomas guardarIdioma(@RequestBody Idiomas idioma) {
		return repository.save(idioma);		
	}
	
	@DeleteMapping("/deleteI/{id}")
	public void eliminarI(@PathVariable Integer id){
		repository.deleteById(id);
	}
}
