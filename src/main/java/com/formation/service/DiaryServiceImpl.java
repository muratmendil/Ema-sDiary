package com.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.DiaryDao;
import com.formation.model.Diary;


@Service
public class DiaryServiceImpl implements DiaryService {
	
	@Autowired
	private DiaryDao diaryDao;
	

	@Override
	public Diary createDiary(Diary diary) {
		return diaryDao.createDiary(diary);
	}
}
