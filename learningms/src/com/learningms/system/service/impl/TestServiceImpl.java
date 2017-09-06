package com.learningms.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.learningms.system.dao.TestDao;
import com.learningms.system.model.ParamConfig;
import com.learningms.system.service.TestService;
@Service
public class TestServiceImpl implements TestService{
	@Resource
	private TestDao testDao;
	@Override
	public List<ParamConfig> getParamConfigList() {
		// TODO Auto-generated method stub
		return testDao.getParamConfigList();
	}

}
