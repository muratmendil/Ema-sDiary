package com.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.ObjectifDao;
import com.formation.dao.UserDao;
import com.formation.model.Objectif;
import com.formation.model.User;


@Service
public class ObjectifServiceImpl implements ObjectifService {

	@Autowired
	private ObjectifDao objectifDao;
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public Objectif createObjectif(int id, Objectif objectif) {
		Objectif newObjectif = objectif;
		User user = userDao.findById(id);
		
		List<Objectif> objectifs = user.getObjectifs();
		
		Objectif finalObjectif;
		if(objectifs != null && objectifs.size() >0 ){
			objectifs.add(newObjectif);
			user.setObjectifs(objectifs);
			newObjectif.setUser(user);
			finalObjectif = objectifDao.createObjectif(newObjectif);

		}else{
			List<Objectif> newObjectifs= new ArrayList<>();
			newObjectifs.add(newObjectif);
			user.setObjectifs(newObjectifs);
			newObjectif.setUser(user);
			finalObjectif = objectifDao.createObjectif(newObjectif);
		}
	
		return finalObjectif;
	}

	@Override
	public Objectif findById(int id) {
		return objectifDao.findById(id);
	}

	@Override
	public List<Objectif> getAll(int id) {
		return objectifDao.getAll(id);
	}
}
