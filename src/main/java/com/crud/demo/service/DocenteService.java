package com.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.interfaceService.IDocenteService;
import com.crud.demo.interfaces.IDocente;
import com.crud.demo.model.Docente;

@Service
public class DocenteService implements IDocenteService{
	@Autowired
	private IDocente data;
	
	
	@Override
	public List<Docente> listar() {
		// TODO Auto-generated method stub
		return (List<Docente>)data.findAll();
	}

	@Override
	public Optional<Docente> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int Save(Docente d) {
		int res=0;
		Docente docente= data.save(d);
		if (docente.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void Delete(int id) {
		data.deleteById(id);
	}

}
