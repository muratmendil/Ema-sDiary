package com.formation.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Objectif;
import com.formation.model.User;


@Repository
@Transactional
public class ObjectifDaoImpl implements ObjectifDao {

		
	@PersistenceContext
	private EntityManager objectifManager;
	
	@Override
	public Objectif createObjectif(Objectif objectif) {
		Objectif ob = null;
		try {
			ob = objectifManager.merge(objectif);

		} catch (NoResultException e) {
		}
		return ob;
	}

	@Override
	public Objectif findById(int id) {
		return objectifManager.find(Objectif.class, id);
	}

	@Override
	public List<Objectif> getAll(int id) {
		//User user =objectifManager.find(User.class, id); 
		return new ArrayList(); 
	}
}
