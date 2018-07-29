package com.assaifiy.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.assaifiy.api.dao.LogActivityDao;
import com.assaifiy.api.model.LogActivity;
import com.assaifiy.api.util.HibernateUtil;

@Repository("logActivityDao")
public class LogActivityDaoImpl implements LogActivityDao {

	private Session session;
	private Logger LOGGER = LoggerFactory.getLogger(LogActivityDaoImpl.class);
	@Override
	public void save(LogActivity logActivity) {
		LOGGER.debug("Save function being called");
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			LOGGER.warn("Saving Log Activity");
			session.save(logActivity);
			session.getTransaction().commit();
		}catch(HibernateException e){
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
		
	}

	@Override
	public List<LogActivity> getLog() {
		List<LogActivity> listActivity = new ArrayList<>();
		LOGGER.debug("Retrieving Log Data");
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			LOGGER.warn("Retrieving Data Log");
			CriteriaQuery<LogActivity> query = builder.createQuery(LogActivity.class);
			Root<LogActivity> root = query.from(LogActivity.class);
			query.select(root);
			Query<LogActivity> q = session.createQuery(query);
			listActivity =q.getResultList();
			return listActivity;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());
			return listActivity;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
	}

}
