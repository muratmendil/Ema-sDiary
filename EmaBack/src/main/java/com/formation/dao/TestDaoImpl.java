package com.formation.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Test;

@Repository
@Transactional
public class TestDaoImpl implements TestDao{

	@PersistenceContext
	private EntityManager testManager;

	@Override
	public Test createTest(Test test) {
		return testManager.merge(test);
	}

	@Override
	public Test findById(int id) {
		return testManager.find(Test.class, id);
	}

}
