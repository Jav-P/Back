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
public class Idiomas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idioma_id")
	private Integer id;
	
	private String idioma;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "idioma_pelicula", joinColumns = @JoinColumn(name = "idioma_id", referencedColumnName = "idioma_id"), 
	inverseJoinColumns = @JoinColumn(name = "pelicula_id", referencedColumnName = "pelicula_id"))
	private List<Pelicula> peliculas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	} 

	public Idiomas(Integer id, String idioma) {
		super();
		this.id = id;
		this.idioma = idioma;
	}

	public Idiomas() {
		super();
	}


	
}
