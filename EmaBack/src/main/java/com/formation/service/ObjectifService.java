package com.formation.service;

import java.util.List;

import com.formation.exeption.ErrorExeption;
import com.formation.model.Objectif;

public interface ObjectifService {
	Objectif createObjectif(Objectif objectif) throws ErrorExeption;
	Objectif findById(int id) throws ErrorExeption;
	List<Objectif> findAllByUserId(int id) throws ErrorExeption;
}
