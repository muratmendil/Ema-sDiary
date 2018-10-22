package com.formation.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Cases;


@Repository
@Transactional
public class CaseDaoImpl implements CaseDao {
	
	@PersistenceContext
	private EntityManager caseManager;


	@Override
	public Cases createCase(Cases cas) {
		return caseManager.merge(cas);
	}

	@Override
	public Cases findById(int id) {
		return caseManager.find(Cases.class, id);
	}
}
