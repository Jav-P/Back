package com.sistema.pelis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.pelis.model.Compra;
import com.sistema.pelis.repository.CompraReporitory;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class CompraController {

	@Autowired
	private CompraReporitory repository;
	
	@GetMapping("/compras")
	public List<Compra> listaCompras(){		
		return repository.findAll(); 
	}
	
	@PostMapping("/addCompra")	
	public Compra guardarSerie(@RequestBody Compra compra) {
		return repository.save(compra);		
	}
	
}
