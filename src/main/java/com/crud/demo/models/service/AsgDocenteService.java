package com.crud.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.models.dao.IAsgDocenteDao;
import com.crud.demo.models.entity.AsgDocente;
import com.crud.demo.models.serviceImp.IAsgDocenteService;

@Service
public class AsgDocenteService implements IAsgDocenteService{
	@Autowired
	private IAsgDocenteDao data;
	
	public List<AsgDocente> listar() {
		// TODO Auto-generated method stub
		return (List<AsgDocente>) data.findAll();
	}
	
	public int Save(AsgDocente a) {
		int res=0;
		AsgDocente asigdoc= data.save(a);
		if (asigdoc.equals(null)) {
			res=1;
		}
		return res;
	}
}
