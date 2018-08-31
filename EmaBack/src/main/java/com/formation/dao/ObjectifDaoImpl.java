package com.formation.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
		Objectif ob = null;
		try {
			ob = objectifManager.merge(objectif);

		} catch (NoResultException e) {
			logger.debug(" Objectif not created");
		}
		return ob;
	}

	@Override
	public Objectif findById(int id) {
		return objectifManager.find(Objectif.class, id);
	}

	@Override
	public List<Objectif> getAll(int id) {
		User user =objectifManager.find(User.class, id); 
		return user.getObjectifs();
	}
}
