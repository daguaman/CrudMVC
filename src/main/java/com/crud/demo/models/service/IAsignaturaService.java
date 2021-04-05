package com.crud.demo.models.service;

import java.util.List;

import com.crud.demo.models.entity.Asignatura;

public interface IAsignaturaService {
    public List<Asignatura> findAll();

    public Asignatura findById(Long id);

    public Asignatura save(Asignatura asignatura);

    public void deleteById(Long id);
}
