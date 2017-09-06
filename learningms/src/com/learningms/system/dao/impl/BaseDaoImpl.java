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
	/*
	 * 保存
	 */
	public Serializable save(Object object){
		Serializable id = getCurrentSession().save(object);
		return id;
	}
	/*
	 * 删除
	 */
	public void delete(Object object){
		getCurrentSession().delete(object);
	}
	/*
	 * 更新
	 */
	public void update(Object object){
		getCurrentSession().update(object);
	}
	/*
	 * 通过id查找
	 */
	public Object findById(Class clazz, Serializable id){
		return getCurrentSession().get(clazz, id);
	}
	/*
	 * 不带参数的hql语句查询
	 */
	public List findByHql(String hql){
		Session session = getCurrentSession();
		Query query = session.createQuery(hql);
		List ret = query.list();
		return ret;
	}
	/*
	 * 不带参数的sql语句查询
	 */
	public List findBySql(String Sql){
		Session session = getCurrentSession();
		Query query = session.createSQLQuery(Sql);
		List ret = query.list();
		return ret;
	}
	/*
	 * 不带参数名的hql语句查询
	 */
	public List findByValueHql(String hql, Object[] paramValue){
		Session session = getCurrentSession();
		Query query = session.createQuery(hql);
		if(paramValue != null){
			for(int i=0; i<paramValue.length;i++){
				query.setParameter(i, paramValue[i]);
			}
		}
		List ret = query.list();
		return ret;
	}
	/*
	 * 不带参数名的sql语句查询
	 */
	public List findByValueSql(String sql, Object[] paramValue){
		Session session = getCurrentSession();
		Query query = session.createSQLQuery(sql);
		if(paramValue != null){
			for(int i=0; i<paramValue.length;i++){
				query.setParameter(i, paramValue[i]);
			}
		}
		List ret = query.list();
		return ret;
	}
	/*
	 * 带参数名的hql语句查询
	 */
	public List findByNameHql(String hql,String[] paramName, Object[] paramValue){
		Session session = getCurrentSession();
		Query query = session.createQuery(hql);
		if(paramValue != null){
			for(int i=0; i<paramValue.length;i++){
				query.setParameter(paramName[i], paramValue[i]);
			}
		}
		List ret = query.list();
		return ret;
	}
	/*
	 * 带参数名的sql语句查询
	 */
	public List findByNameSql(String sql,String[] paramName, Object[] paramValue){
		Session session = getCurrentSession();
		Query query = session.createSQLQuery(sql);
		if(paramValue != null){
			for(int i=0; i<paramValue.length;i++){
				query.setParameter(paramName[i], paramValue[i]);
			}
		}
		List ret = query.list();
		return ret;
	}
	/*
	 * 一个参数名的hql语句in查询
	 */
	public List findByNameHqlForIn(String hql,String paramName, Object[] paramValue){
		Session session = getCurrentSession();
		Query query = session.createQuery(hql);
		if(paramValue != null){
			query.setParameterList(paramName, paramValue);
		}
		List ret = query.list();
		return ret;
	}
	/*
	 * 一个参数名的sql语句in查询
	 */
	public List findByNameSqlForIn(String sql,String paramName, Object[] paramValue){
		Session session = getCurrentSession();
		Query query = session.createSQLQuery(sql);
		if(paramValue != null){
			query.setParameterList(paramName, paramValue);
		}
		List ret = query.list();
		return ret;
	}
	
}
