package com.embassy.user.dao;

import java.util.List;

import com.embassy.user.dao.entity.User;

public interface IUserDAO {

	public User addUser(User user);

	public User updateUser(User user);

	public boolean deleteUser(int userId);

	public User getUser(int userId);

	public List<User> getUsers();

}
