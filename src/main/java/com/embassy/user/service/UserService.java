package com.embassy.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.embassy.user.dao.IUserDAO;
import com.embassy.user.dao.entity.User;


@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDAO userDAO;

	@Override
	public User createUser(User user) {
		return userDAO.addUser(user);
	}

	@Override
	public User viewUser(int userId) {
		return userDAO.getUser(userId);
	}

	@Override
	public List<User> getUserList() {
		return userDAO.getUsers();
	}

	@Override
	public User updateUser(User user) {
		return userDAO.updateUser(user);
	}

	@Override
	public boolean activateUser(int userId) {
		User user = userDAO.getUser(userId);
		user.setIsActive(1);
		userDAO.updateUser(user);
		return true;
	}

	@Override
	public boolean deactivateUser(int userId) {
		User user = userDAO.getUser(userId);
		user.setIsActive(0);
		userDAO.updateUser(user);
		return true;
	}

	@Override
	public boolean resetPassword(int userId) {
		User user = userDAO.getUser(userId);
		user.setPassword("123456");
		userDAO.updateUser(user);
		return true;
	}

	@Override
	public boolean lockUser(int userId) {
		User user = userDAO.getUser(userId);
		user.setAccountLocked(1);
		userDAO.updateUser(user);
		return true;
	}

	@Override
	public boolean unlockUser(int userId) {
		User user = userDAO.getUser(userId);
		user.setAccountLocked(0);
		userDAO.updateUser(user);
		return true;
	}

}
