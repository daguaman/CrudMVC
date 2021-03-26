package com.crud.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.crud.demo.model.Asignatura;

public interface IAsignaturaService {
	public List<Asignatura> listar();
	public Optional<Asignatura> listarid(int id);
	public int Save(Asignatura a);
	public void Delete (int id);
}
