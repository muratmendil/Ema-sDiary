package com.formation.dao;

import com.formation.model.Test;

public interface TestDao {
	Test createTest(Test test);
	Test findById(int id);
}
