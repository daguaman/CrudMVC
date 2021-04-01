package com.crud.demo.models.serviceImp;

import java.util.List;

import com.crud.demo.models.entity.AsgDocente;

public interface IAsgDocenteService {
	public List<AsgDocente> listar();
	public int Save(AsgDocente d);
}
