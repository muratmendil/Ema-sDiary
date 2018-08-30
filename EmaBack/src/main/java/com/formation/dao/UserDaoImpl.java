package com.formation.dao;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao, Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@PersistenceContext
	private EntityManager userManager;

	@Override
	public User createUser(User user) {
		return userManager.merge(user);
	}

	@Override
	public User findById(int id) {
		return userManager.find(User.class, id);
	}

	@Override
	public String logout() {
		String user = null;
		String identifier = user;

		// invalidate the session
		logger.debug("invalidating session for '{}'", identifier);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		logger.info("logout successful for '{}'", identifier);
		return "index";
	}

	@Override
	public User findByEmail(String email, String password) {
		String sql = "SELECT user.* FROM user AS user WHERE email = ? && password = ?";
		Query query = userManager.createNativeQuery(sql, User.class);
		query.setParameter(1, email);
		query.setParameter(2, password);

		User user = (User) query.getSingleResult();
		return user;
	}
}