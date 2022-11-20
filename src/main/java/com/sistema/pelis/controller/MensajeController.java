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

import com.sistema.pelis.model.Mensaje;
import com.sistema.pelis.repository.MensajeReporitory;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class MensajeController {

	@Autowired
	private MensajeReporitory repository;
	
	@GetMapping("/mensajes")
	public List<Mensaje> listaMensajes(){		
		return repository.findAll(); 
	}
	
	@PostMapping("/addM")	
	public Mensaje guardarMensaje(@RequestBody Mensaje mensaje) {
		return repository.save(mensaje);		
	}

	@DeleteMapping("/deleteM/{id}")
	public void eliminarS(@PathVariable Integer id){
		repository.deleteById(id);
	}
	
}
