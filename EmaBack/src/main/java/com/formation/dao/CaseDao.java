package com.formation.dao;

import com.formation.model.Cases;

public interface CaseDao {
	Cases createCase(Cases cas);
	Cases findById(int id);
}

