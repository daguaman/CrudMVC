package com.crud.demo.models.dao;

import com.crud.demo.models.entity.Docente;

import org.springframework.data.repository.CrudRepository;

public interface DocenteDAO extends CrudRepository<Docente, Long>{
    
}
