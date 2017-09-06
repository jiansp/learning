package com.learningms.system.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learningms.system.dao.BaseDao;
import com.learningms.system.model.ParamConfig;

public class BaseDaoImpl implements BaseDao{
	private static final long serialVersionUID = 1L;
	@Resource
	public SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public Serializable save(Object object){
		Serializable id = getCurrentSession().save(object);
		return id;
	}
	
	public void delete(Object object){
		getCurrentSession().delete(object);
	}
	
	public void update(Object object){
		getCurrentSession().update(object);
	}
	
	public Object findById(Class clazz, Serializable id){
		return getCurrentSession().get(clazz, id);
	}
	
	public List findByHql(String hql){
		Session session = getCurrentSession();
		Query query = session.createQuery(hql);
		List ret = query.list();
		return ret;
	}
}
