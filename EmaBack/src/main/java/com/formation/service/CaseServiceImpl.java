package com.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.CaseDao;
import com.formation.model.Cases;

@Service
public class CaseServiceImpl implements CaseService {
	
	@Autowired CaseDao caseDao;

	@Override
	public Cases createCase(Cases cas) {
		return caseDao.createCase(cas);
	}

	@Override
	public Cases findById(int id) {
		return caseDao.findById(id);
	}

}
