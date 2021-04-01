package com.crud.demo.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.models.dao.IDocenteDao;
import com.crud.demo.models.entity.Docente;
import com.crud.demo.models.serviceImp.IDocenteService;

@Service
public class DocenteService implements IDocenteService{
	@Autowired
	private IDocenteDao data;
	
	
	@Override
	public List<Docente> listar() {
		// TODO Auto-generated method stub
		return (List<Docente>)data.findAll();
	}

	@Override
	public Optional<Docente> listarId(Long id) {
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
	public void Delete(Long id) {
		data.deleteById(id);
	}

}
