package com.crud.demo.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.models.entity.AsgDocente;

@Repository
public interface IAsgDocenteDao extends CrudRepository<AsgDocente, Long>{

}
