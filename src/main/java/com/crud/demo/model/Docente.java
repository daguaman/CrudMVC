package com.crud.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Docente")

public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDocente;
	private String Nombres;
	private String Identificacion;
	
	
	public Docente(int idDocente, String nombres, String identificacion) {
		super();
		this.idDocente = idDocente;
		this.Nombres = nombres;
		this.Identificacion = identificacion;
	}
	
	public int getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		this.Nombres = nombres;
	}
	public String getIdentificacion() {
		return Identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.Identificacion = identificacion;
	}
	
	

}
