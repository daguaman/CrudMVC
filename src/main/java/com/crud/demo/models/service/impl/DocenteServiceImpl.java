package com.crud.demo.models.service.impl;

import java.util.List;

import com.crud.demo.models.dao.DocenteDAO;
import com.crud.demo.models.entity.Docente;
import com.crud.demo.models.service.IDocenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceImpl implements IDocenteService{
    
    @Autowired
    DocenteDAO dao;

    @Override
    public List<Docente> findAll() {
        return (List<Docente>) dao.findAll();
    }

    @Override
    public Docente findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Docente save(Docente docente) {
        return dao.save(docente);
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);       
    }

    
}
