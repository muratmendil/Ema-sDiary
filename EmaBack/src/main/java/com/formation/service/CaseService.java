package com.formation.service;

import com.formation.model.Cases;

public interface CaseService {
	Cases createCase(Cases cas);
	Cases findById(int id);
}
