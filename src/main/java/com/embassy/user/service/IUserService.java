package com.embassy.user.service;

import java.util.List;

import com.embassy.user.dao.entity.User;

public interface IUserService {

	public User createUser(User user);

	public User viewUser(int userId);

	public List<User> getUserList();

	public User updateUser(User user);

	public boolean activateUser(int userId);

	public boolean deactivateUser(int userId);

	public boolean resetPassword(int userId);

	public boolean lockUser(int userId);

	public boolean unlockUser(int userId);

}
