package com.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.ObjectifDao;
import com.formation.dao.UserDao;
import com.formation.exeption.ErrorExeption;
import com.formation.model.Objectif;
import com.formation.model.User;


@Service
public class ObjectifServiceImpl implements ObjectifService {

	@Autowired
	private ObjectifDao objectifDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Objectif createObjectif(Objectif objectif) throws ErrorExeption {		
		if(objectif.fieldNotEmpty()){
			return objectifDao.createObjectif(objectif);
		}
		throw new ErrorExeption("Null value", "Un ou plusieurs propiété de objectif est null");
	}

	@Override
	public List<Objectif> findByUserId(int id) throws ErrorExeption {
		List<Objectif> objectifs = objectifDao.findByUserId(id);
		if(objectifs.size() == 0){
			throw new ErrorExeption("Aucun objectif", "Cette utilisateur n'a aucun objectif");
		}
		return objectifs;
	}

	@Override
	public Objectif findById(int id) throws ErrorExeption {
		// TODO Auto-generated method stub
		return null;
	}
}
