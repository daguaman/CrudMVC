package com.crud.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.crud.demo.model.Docente;

public interface IDocenteService {
	public List<Docente> listar();
	public Optional<Docente>listarId(int id);
	public int Save(Docente d);
	public void Delete(int id);
}
