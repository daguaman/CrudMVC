package com.crud.demo.models.dao;

import com.crud.demo.models.entity.Asignatura;

import org.springframework.data.repository.CrudRepository;

public interface AsignaturaDAO extends CrudRepository<Asignatura, Long>{
    
}
