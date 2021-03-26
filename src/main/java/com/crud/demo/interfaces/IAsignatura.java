package com.crud.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.model.Asignatura;

@Repository
public interface IAsignatura extends CrudRepository<Asignatura, Integer>{

}
