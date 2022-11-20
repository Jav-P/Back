package com.sistema.pelis.model;

import java.time.LocalDate;
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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaCompra;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Persona persona;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "compra_pelicula", joinColumns = @JoinColumn(name = "compra_id", referencedColumnName = "compra_id"), 
	inverseJoinColumns = @JoinColumn(name = "pelicula_id", referencedColumnName = "pelicula_id"))
	private List<Pelicula> peliculas;
	
	public Persona getUsuario() {
		return persona;
	}

	public void setUsuario(Persona persona) {
		this.persona = persona;
	}


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

	public LocalDate getFechaEstreno() {
		return fechaCompra;
	}

	public void setFechaEstreno(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Compra(Integer id, @NotNull Integer pago, @NotNull LocalDate fechaCompra, Persona persona) {
		super();
		this.id = id;
		this.pago = pago;
		this.fechaCompra = fechaCompra;
		this.persona = persona;
	}

	public Compra() {
		super();
	}

	

	
	
}
