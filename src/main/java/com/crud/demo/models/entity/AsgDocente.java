package com.crud.demo.models.entity;



import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ASGDOC")
@IdClass(AsgDocente.class)

public class AsgDocente implements Serializable{
	
	@Id
    @Column(name="IDDOC")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoc;

	@Id
    @Column(name="IDASG")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsg;
    
    private String nombreAsg;

    private String codigoAsg;
	
	private String Nombres;
	
	private String Identificacion;
     
    
	public AsgDocente() {
		super();
	}
	

	public AsgDocente(Long idDoc, Long idAsg) {
		super();
		this.idDoc = idDoc;
		this.idAsg = idAsg;
	}
	



	public AsgDocente(Long idDoc, Long idAsg, String nombreAsg, String codigoAsg, String nombres,
			String identificacion) {
		super();
		this.idDoc = idDoc;
		this.idAsg = idAsg;
		this.nombreAsg = nombreAsg;
		this.codigoAsg = codigoAsg;
		Nombres = nombres;
		Identificacion = identificacion;
	}


	public Long getIdDoc() {
		return idDoc;
	}


	public void setIdDoc(Long idDoc) {
		this.idDoc = idDoc;
	}


	public Long getIdAsg() {
		return idAsg;
	}


	public void setIdAsg(Long idAsg) {
		this.idAsg = idAsg;
	}


	public String getNombreAsg() {
		return nombreAsg;
	}


	public void setNombreAsg(String nombreAsg) {
		this.nombreAsg = nombreAsg;
	}


	public String getCodigoAsg() {
		return codigoAsg;
	}


	public void setCodigoAsg(String codigoAsg) {
		this.codigoAsg = codigoAsg;
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


	


	
}
