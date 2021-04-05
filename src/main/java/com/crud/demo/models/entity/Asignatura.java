package com.crud.demo.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="asignaturas")
public class Asignatura implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", length = 100, nullable = false)
    private String codigo;

    @Column(name = "nombres", length = 255, nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "asignaturas")
    private List<Docente> docentes;

    
    public Asignatura(){

    }

    public Asignatura(Long id, String codigo, String nombre, List<Docente> docentes) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.docentes = docentes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    private static final long serialVersionUID = 9067855711744545608L;


    

}