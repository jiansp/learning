package com.learningms.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learningms.system.dao.impl.BaseDaoImpl;
import com.learningms.system.model.ParamConfig;
import com.learningms.system.service.TestService;
import com.learningms.system.vo.Json;

@Controller
@RequestMapping("/test")
public class TextController extends BaseDaoImpl{
	@Resource
	private TestService testService;
	@RequestMapping("/test")
	@ResponseBody
	public ParamConfig test(HttpServletRequest request, String name){
		//Json result = new Json();
		List<ParamConfig> list = testService.getParamConfigList();
		return list.get(Integer.parseInt(name));
	}

}
