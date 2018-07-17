package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.ObjectifDao;
import com.formation.model.Objectif;


@Service
public class ObjectifServiceImpl implements ObjectifService {

	@Autowired
	private ObjectifDao objectifDao;
	
	
	@Override
	public Objectif createObjectif(Objectif objectif) {
		Objectif obj = null;
		 obj =  objectifDao.createObjectif(objectif);
		return obj;
	}

	@Override
	public Objectif findById(int id) {
		return objectifDao.findById(id);
	}

	@Override
	public List<Objectif> getAll() {
		return objectifDao.getAll();
	}
}
