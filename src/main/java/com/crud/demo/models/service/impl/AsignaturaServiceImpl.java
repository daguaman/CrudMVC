package com.crud.demo.models.service.impl;

import java.util.List;

import com.crud.demo.models.dao.AsignaturaDAO;
import com.crud.demo.models.entity.Asignatura;
import com.crud.demo.models.service.IAsignaturaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService{

    @Autowired
    AsignaturaDAO dao;

    @Override
    public List<Asignatura> findAll() {
        return (List<Asignatura>) dao.findAll();
    }

    @Override
    public Asignatura findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Asignatura save(Asignatura asignatura) {
        return dao.save(asignatura);
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);        
    }

    
    
}
