package com.embassy.user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.embassy.user.dao.entity.User;

@Transactional
@Repository
public class UserDAOImpl implements IUserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User addUser(User user) {
		user.setPassword("123456");
		entityManager.persist(user);
		entityManager.flush();
		return user;
	}

	@Override
	public User updateUser(User user) {
		return entityManager.merge(user);
	}

	@Override
	public boolean deleteUser(int userId) {
		entityManager.remove(getUser(userId));
		return false;
	}

	@Override
	public User getUser(int userId) {
		return entityManager.find(User.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		String hql = "FROM User as usr ORDER BY usr.userId";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}

}
