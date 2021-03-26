package com.crud.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Asignatura")
public class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAsignatura;
	private String Nombre;
	private String Codigo;
	
	
	public Asignatura() {
		super();
	}

	public Asignatura(int id, String nombre, String codigo) {
		super();
		this.idAsignatura = id;
		Nombre = nombre;
		Codigo = codigo;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setId(int id) {
		this.idAsignatura= id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	
	
}
