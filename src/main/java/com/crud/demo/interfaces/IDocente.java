package com.crud.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.model.Docente;

@Repository
public interface IDocente extends CrudRepository<Docente, Integer>{

}
