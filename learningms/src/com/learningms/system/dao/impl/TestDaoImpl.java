package com.learningms.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.learningms.system.dao.TestDao;
import com.learningms.system.model.ParamConfig;
@Repository
public class TestDaoImpl extends BaseDaoImpl implements TestDao{

	@Override
	public List<ParamConfig> getParamConfigList() {
		// TODO Auto-generated method stub
		String hql = "from ParamConfig";
		return this.findByHql(hql);
	}

}
