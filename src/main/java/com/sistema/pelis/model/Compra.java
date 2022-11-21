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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "compra_id")
	private Integer id;
	
	@NotNull
	private Integer pago;
	
	@NotNull
	private String fechaCompra;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Persona persona;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "compra_pelicula", joinColumns = @JoinColumn(name = "compra_id", referencedColumnName = "compra_id"), 
	inverseJoinColumns = @JoinColumn(name = "pelicula_id", referencedColumnName = "pelicula_id"))
	private List<Pelicula> peliculas;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPago() {
		return pago;
	}

	public void setPago(Integer pago) {
		this.pago = pago;
	}

	public String getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public Compra() {
		super();
	}

	
	
}
