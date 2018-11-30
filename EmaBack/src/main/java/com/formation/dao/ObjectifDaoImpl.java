package com.formation.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Objectif> findByUserId(int id) {
		String sql = "SELECT objectif.* FROM objectif AS objectif WHERE user_Id = ?";
		List<Objectif> objectifs = new ArrayList<Objectif>();
		try {
			objectifs = objectifManager.createNativeQuery(sql).setParameter(1, id).getResultList();
		} catch (NoResultException e) {
		}
		return objectifs;
	}

	@Override
	public Objectif findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
