package com.sistema.pelis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "peliculas")
public class Pelicula {
	
	
	@Id
	@Column(name = "pelicula_id")
	private Integer id;
	
	@NotNull
	private String titulo;

	@NotNull
	private String personas;

	@NotNull
	private String sinopsis;

	@NotNull
	private Integer duracion;
	
	@NotNull
	private String fechaEstreno;
	
	@NotNull
	private Double calificacion;

	private Integer transacciones;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "clasificacion_id")
	private Clasificacion clasificacion;
	
	@ManyToMany
	@JoinTable(name = "genero_pelicula", 
	joinColumns = @JoinColumn(name = "pelicula_id", referencedColumnName = "pelicula_id"),
	inverseJoinColumns = @JoinColumn(name = "genero_id", referencedColumnName = "genero_id"))
	private List<Genero> generos;

	@ManyToMany
	@JoinTable(name = "idioma_pelicula", 
	joinColumns = @JoinColumn(name = "pelicula_id", referencedColumnName = "pelicula_id"), 
	inverseJoinColumns = @JoinColumn(name = "idioma_id", referencedColumnName = "idioma_id"))
	private List<Idiomas> idiomas;
	
	@ManyToOne 
	@JoinColumn(name = "serie_id")
	private Serie serie;
	
	@ManyToOne 
	@JoinColumn(name = "coleccion_id")
	private Coleccion coleccion;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "compra_pelicula", 
	joinColumns = @JoinColumn(name = "pelicula_id", referencedColumnName = "pelicula_id"), 
	inverseJoinColumns = @JoinColumn(name = "compra_id", referencedColumnName = "compra_id"))
	private List<Compra> compras;	

	public Coleccion getColeccion() {
		return coleccion;
	}

	public void setColeccion(Coleccion coleccion) {
		this.coleccion = coleccion;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

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

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public Double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	public List<Idiomas> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idiomas> idiomas) {
		this.idiomas = idiomas;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	

	public String getPersonas() {
		return personas;
	}

	public void setPersonas(String personas) {
		this.personas = personas;
	}

	public Integer getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(Integer transacciones) {
		this.transacciones = transacciones;
	}

	public Pelicula() {
		super();
	}

}
