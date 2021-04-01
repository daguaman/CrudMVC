package com.crud.demo.models.serviceImp;

import java.util.List;
import java.util.Optional;

import com.crud.demo.models.entity.Asignatura;

public interface IAsignaturaService {
	public List<Asignatura> listar();
	public Optional<Asignatura> listarid(Long id);
	public int Save(Asignatura a);
	public void Delete (Long id);
	public void findCommentsByUUID(String uuid);
	
	
}
