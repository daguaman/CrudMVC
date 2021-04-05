package com.crud.demo.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="docentes")
public class Docente implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identificacion", length = 13, nullable = false)
    private String identificacion;

    @Column(name = "nombres", length = 255, nullable = false)
    private String nombre;

    @JoinTable(
        name = "asignatura_docente",
        joinColumns = @JoinColumn(name="asignatura_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name="docente_id", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Asignatura> asignaturas;

    
    public Docente(){

    }

    public Docente(Long id, String identificacion, String nombre, List<Asignatura> asignaturas) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.asignaturas = asignaturas;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private static final long serialVersionUID = -1910414118975755058L;


}
