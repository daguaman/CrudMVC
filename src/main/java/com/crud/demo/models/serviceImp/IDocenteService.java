package com.crud.demo.models.serviceImp;

import java.util.List;
import java.util.Optional;

import com.crud.demo.models.entity.Docente;

public interface IDocenteService {
	public List<Docente> listar();
	public Optional<Docente>listarId(Long id);
	public int Save(Docente d);
	public void Delete(Long id);
}
