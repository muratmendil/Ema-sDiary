package com.formation.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.formation.model.Diary;

public class DiaryDaoImpl implements DiaryDao {
	
private static final Logger logger = LoggerFactory.getLogger(ObjectifDaoImpl.class);
	
	@PersistenceContext
	private EntityManager diaryManager;

	@Override
	public Diary createDiary(Diary diary) {
		return diaryManager.merge(diary);
	}
}
