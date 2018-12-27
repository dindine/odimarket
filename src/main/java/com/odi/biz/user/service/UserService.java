package com.odi.biz.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odi.biz.user.UserVO;
import com.odi.biz.user.impl.UserDAO;

@Service("userService")
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public UserVO findById(String id) {
		return userDAO.findById(id);
	}

	public UserVO findOne(String id, String password) {
		return userDAO.findOne(id, password);
	}

	public void save(UserVO user) {
		userDAO.save(user);
	}

	public UserVO nickname(String id) {
		return userDAO.nick(id);
	}

	public boolean update(UserVO user) {
		UserVO existed = findById(user.getCust_id());
		if (existed == null) {
			return false;
		}

		user.setCust_key("To be updated");
		user.setCust_login_type(existed.getCust_login_type());

		return userDAO.update(user);
	}

	public boolean delete(String id, String password) {
		UserVO existed = userDAO.findById(id);

		if (existed == null) {
			return false;
		} else if (existed.getCust_pwd().equals(password)) {
			return userDAO.delete(id);
		}

		return false;

	}

}