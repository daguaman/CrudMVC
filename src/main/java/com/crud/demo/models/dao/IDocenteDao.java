package com.crud.demo.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.models.entity.Docente;

@Repository
public interface IDocenteDao extends CrudRepository<Docente, Long>{

}
