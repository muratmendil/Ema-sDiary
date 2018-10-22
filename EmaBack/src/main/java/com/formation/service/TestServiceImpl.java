package com.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.TestDao;
import com.formation.model.Test;

@Service
public class TestServiceImpl implements TestService{

	@Autowired TestDao testDao;

	@Override
	public Test createTest(Test test) {
		return testDao.createTest(test);
	}

	@Override
	public Test findById(int id) {
		return testDao.findById(id);
	}
	

}
