package com.crud.demo.models.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Docente")

public class Docente {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NOMBRE", nullable = false)
	private String Nombres;
	
	@Column(name="IDENTIFICACION", nullable = false)
	private String Identificacion;
	
	 @ManyToMany(mappedBy = "Docente")
	 private List<Asignatura> asignaturas;
	 
	 public Docente() {
		
	 }
	
	public Docente(Long idDocente, String nombres, String identificacion) {
		super();
		this.id = idDocente;
		Nombres = nombres;
		Identificacion = identificacion;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long idDocente) {
		this.id = idDocente;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	public String getIdentificacion() {
		return Identificacion;
	}
	public void setIdentificacion(String identificacion) {
		Identificacion = identificacion;
	}

	@Override
	public String toString() {
		return "Docente [id=" + id + ", Nombres=" + Nombres + ", Identificacion=" + Identificacion + ", asignaturas="
				+ asignaturas + "]";
	}
	
	

}
