package com.learningms.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.learningms.system.dao.UsersDao;
import com.learningms.system.model.Users;

@Repository
public class UsersDaoImpl extends BaseDaoImpl implements UsersDao {
	public Users getUserInfo(String username) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("from Users where userName=:userName");
		List<Users> users = this.findByNameHql(sql.toString(), new String[]{"userName"}, new Object[]{username});
		
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		
		return null;
	}

	
}
