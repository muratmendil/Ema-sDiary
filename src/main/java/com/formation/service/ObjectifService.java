package com.formation.service;

import java.util.List;

import com.formation.model.Objectif;

public interface ObjectifService {
	Objectif createObjectif(Objectif objectif);
	Objectif findById(int id);
	List<Objectif> getAll(int id);
}
