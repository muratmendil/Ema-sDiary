package com.formation.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;

import com.formation.model.Objectif;
import com.formation.model.User;


@Repository
@Transactional
public class ObjectifDaoImpl implements ObjectifDao {

	
	private static final Logger logger = LoggerFactory.getLogger(ObjectifDaoImpl.class);
	
	@PersistenceContext
	private EntityManager objectifManager;
	
	@Override
	public Objectif createObjectif(Objectif objectif) {
		return objectifManager.merge(objectif);
	}

	@Override
	public Objectif findById(int id) {
		return objectifManager.find(Objectif.class, id);
	}

	@Override
	public List<Objectif> getAll(int id) {
		User user =objectifManager.find(User.class, id); 
		
		System.out.println("start"+user);
		if(user.getObjectifs() != null){
			return user.getObjectifs();
		}
		return new ArrayList<Objectif>();
	}
}
