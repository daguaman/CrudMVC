package com.crud.demo.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.models.dao.IAsignaturaDao;
import com.crud.demo.models.entity.Asignatura;
import com.crud.demo.models.serviceImp.IAsignaturaService;


@Service
public class AsignaturaService implements IAsignaturaService{

	@Autowired
	private IAsignaturaDao data;
	@Override
	public List<Asignatura> listar() {
		// TODO Auto-generated method stub
		return (List<Asignatura>) data.findAll();
	}

	@Override
	public Optional<Asignatura> listarid(Long id) {
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
	public void Delete(Long id) {
		data.deleteById(id);
	}
	
	public void findCommentsByUUID(String uuid){
		
		
	}
}
