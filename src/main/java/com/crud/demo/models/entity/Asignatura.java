package com.crud.demo.models.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "Asignatura")
public class Asignatura {
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "CODIGO", nullable = false)
    private String codigo;
	
	@JoinTable(
	        name = "ASGDOC",
	        joinColumns = @JoinColumn(name = "IDASG", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="IDDOC", nullable = false)
	    )
	@ManyToMany(cascade = CascadeType.ALL)
	
	private List<Docente> docentes;
	
	public Asignatura() {
		super();
	}
	
	//para el metodo ManytoMany
	public void addAsignatura(Docente docente){
        if(this.docentes == null){
            this.docentes = new ArrayList<>();
        }
        
        this.docentes.add(docente);
    }

	public Asignatura(Long idAsignatura, String nombre, String codigo) {
		super();
		this.id = idAsignatura;
		this.nombre = nombre;
		this.codigo = codigo;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id= id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String name) {
		nombre = name;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String code) {
		codigo = code;
	}



	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", docentes=" + docentes + "]";
	}
	
	
}
