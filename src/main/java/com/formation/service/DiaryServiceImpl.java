package com.formation.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.dao.DiaryDao;
import com.formation.model.Diary;

public class DiaryServiceImpl implements DiaryService {
	
	@Autowired
	private DiaryDao diaryDao;
	

	@Override
	public Diary createDiary(Diary diary) {
		return diaryDao.createDiary(diary);
	}
}
