package com.crud.demo.models.service;

import java.util.List;

import com.crud.demo.models.entity.Docente;

public interface IDocenteService {
    public List<Docente> findAll();

    public Docente findById(Long id);

    public Docente save(Docente docente);

    public void deleteById(Long id);
}
