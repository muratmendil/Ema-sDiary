package com.formation.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Diary;

@Repository
@Transactional
public class DiaryDaoImpl implements DiaryDao {
	
private static final Logger logger = LoggerFactory.getLogger(ObjectifDaoImpl.class);
	
	@PersistenceContext
	private EntityManager diaryManager;

	@Override
	public Diary createDiary(Diary diary) {
		return diaryManager.merge(diary);
	}
}
