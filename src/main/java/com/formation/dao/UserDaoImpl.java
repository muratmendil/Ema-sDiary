package com.formation.dao;

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
public class UserDaoImpl implements UserDao {
	
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
	public User findByEmail(String email, String password) {
		String sql = "SELECT user.* FROM user AS user WHERE email = ? && password = ?";
		Query query = userManager.createNativeQuery(sql, User.class);
		query.setParameter(1, email);
		query.setParameter(2, password);

		User user = (User) query.getSingleResult();
		return user;
	}
}
