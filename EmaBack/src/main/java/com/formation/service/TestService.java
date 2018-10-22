package com.formation.service;

import com.formation.model.Test;

public interface TestService {
	Test createTest(Test test);
	Test findById(int id);
}
