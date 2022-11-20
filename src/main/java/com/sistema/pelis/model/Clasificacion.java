package com.sistema.pelis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Clasificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clasificacion_id")
	private Integer id;
	
	private String clasificacion;
	
	@JsonBackReference
	@OneToMany(mappedBy = "clasificacion")
	private List<Pelicula> peliculas;	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Clasificacion(String clasificacion) {
		super();
		this.clasificacion = clasificacion;
	}
	
	public Clasificacion() {
		super();
	}
	
}
