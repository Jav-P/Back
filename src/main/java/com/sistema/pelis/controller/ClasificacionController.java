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

import com.sistema.pelis.model.Clasificacion;
import com.sistema.pelis.repository.ClasificacionReporitory;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class ClasificacionController {

	@Autowired
	private ClasificacionReporitory repository;
	
	@GetMapping("/clasi")
	public List<Clasificacion> listaClasificacion(){		
		return repository.findAll(); 
	}
	
	@PostMapping("/addC")	
	public Clasificacion guardarClasificacion(@RequestBody Clasificacion clasificacion) {
		return repository.save(clasificacion);		
	}
	
	@DeleteMapping("/deleteC/{id}")
	public void eliminarI(@PathVariable Integer id){
		repository.deleteById(id);
	}
}
