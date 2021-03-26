package com.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.interfaceService.IAsignaturaService;
import com.crud.demo.interfaces.IAsignatura;
import com.crud.demo.model.Asignatura;


@Service
public class AsignaturaService implements IAsignaturaService{

	@Autowired
	private IAsignatura data;
	@Override
	public List<Asignatura> listar() {
		// TODO Auto-generated method stub
		return (List<Asignatura>) data.findAll();
	}

	@Override
	public Optional<Asignatura> listarid(int id) {
		return data.findById(id);
	}

	@Override
	public int Save(Asignatura a) {
		int res=0;
		Asignatura asignatura= data.save(a);
		if (asignatura.equals(null)) {
			res=1;
		}
		return res;

	}

	@Override
	public void Delete(int id) {
		data.deleteById(id);
	}
	

}
