package com.unir.springboot.app.msusers.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unir.springboot.app.msusers.models.dao.UserDao;
import com.unir.springboot.app.msusers.models.entity.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserDao userdao;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>)userdao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
		return userdao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		return userdao.findByUsername(username);
	}

	@Override
	@Transactional
	public User save(User user) {
		return userdao.save(user);
	}

	@Override
	@Transactional
	public void DeleteById(Long id) {
		userdao.deleteById(id);
	}

}
