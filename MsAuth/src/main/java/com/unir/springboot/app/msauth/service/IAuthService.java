package com.unir.springboot.app.msauth.service;

import com.unir.springboot.app.msauth.models.User;

public interface IAuthService {
	public User findByUsername(String username);
}
