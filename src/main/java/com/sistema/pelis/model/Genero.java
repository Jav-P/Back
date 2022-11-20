package com.sistema.pelis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genero_id")
	private Integer id;
	
	private String titulo;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "genero_pelicula", 
	joinColumns = @JoinColumn(name = "genero_id", referencedColumnName = "genero_id"),
	inverseJoinColumns = @JoinColumn(name = "pelicula_id", referencedColumnName = "pelicula_id"))
	private List<Pelicula> peliculas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public Genero() {
		super();
	}

	
	
	
}
