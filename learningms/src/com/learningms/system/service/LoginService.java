package com.learningms.system.service;

import com.learningms.system.model.Users;

public interface LoginService {
	public Users login(String username, String password) throws Exception;
}
