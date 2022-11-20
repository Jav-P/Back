package com.sistema.pelis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "persona", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Integer id;
	
	@NotNull
	@Column(name="nombre")
	private String nombre;
	
	@NotNull
	private String contrasena;
	
	private Integer referido;
	
	private Integer puntos;
	
	private Integer transacciones;
	
	@JsonBackReference(value="compras")
	@OneToMany(mappedBy = "persona")
	private List<Compra> compras;
	
	@JsonBackReference
	@OneToMany(mappedBy = "persona")
	private List<Mensaje> mensajes;
	
	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	

	public Integer getReferido() {
		return referido;
	}

	public void setReferido(Integer referido) {
		this.referido = referido;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}


	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contraseña) {
		this.contrasena = contraseña;
	}

	public Integer getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(Integer transacciones) {
		this.transacciones = transacciones;
	}

	public Persona() {
		super();
	}








	
	
}
