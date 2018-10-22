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
	public Objectif createObjectif(int id, Objectif objectif) throws ErrorExeption {
		Objectif newObjectif = objectif;
		
		if(newObjectif.fieldNotEmpty()){
			User user = userDao.findById(id);
			/*
			List<Objectif> objectifs = user.getObjectifs();
			Objectif finalObjectif;
			objectifs.add(newObjectif);
			user.setObjectifs(objectifs);
			newObjectif.setUser(user);
			finalObjectif = objectifDao.createObjectif(newObjectif);
			return finalObjectif; */
		}
		throw new ErrorExeption("Null value", "Un ou plusieurs propiété de objectif est null");
	}

	@Override
	public Objectif findById(int id) throws ErrorExeption {
		Objectif objectif = objectifDao.findById(id);
		if(objectif == null){
			throw new ErrorExeption("Null value", "Ce user n'a aucun objectif");
		}
		return objectif;
	}

	@Override
	public List<Objectif> getAll(int id) throws ErrorExeption{
		List<Objectif> objectifs = objectifDao.getAll(id);
		if(objectifs.size() == 0){
			throw new ErrorExeption("Aucun objectif", "Cette utilisateur n'a aucun objectif");
		}
		return objectifs;
	}
}
