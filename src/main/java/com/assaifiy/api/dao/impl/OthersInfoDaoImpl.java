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

import com.assaifiy.api.dao.OthersInfoDao;
import com.assaifiy.api.model.OthersInfo;
import com.assaifiy.api.util.HibernateUtil;

@Repository("othersInfoDao")
public class OthersInfoDaoImpl implements OthersInfoDao{

	private Session session;
	private Logger LOGGER = LoggerFactory.getLogger(OthersInfo.class);
	@Override
	public boolean save(OthersInfo othersInfo) {
		LOGGER.debug("Save Bike Other infos function being called");
		try{
			LOGGER.warn("Opening Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			LOGGER.warn("Saving new other info : "+othersInfo.getInfoTitle());
			session.save(othersInfo);
			session.getTransaction().commit();		
			return true;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());		
			return false;
		}
	}

	@Override
	public boolean update(OthersInfo othersInfo) {
		LOGGER.debug("Save Bike Other infos function being called");
		try{
			LOGGER.warn("Opening Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			LOGGER.warn("Saving new other info : "+othersInfo.getInfoTitle());
			session.update(othersInfo);
			session.getTransaction().commit();		
			return true;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());		
			return false;
		}
	}

	@Override
	public List<OthersInfo> getAllData(String bikeId) {
		LOGGER.debug("Retrieving bike data");
		List<OthersInfo> listOthersInfo= new ArrayList<>();
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			LOGGER.warn("Retrieving Data");
			CriteriaQuery<OthersInfo> query = builder.createQuery(OthersInfo.class);
			Root<OthersInfo> root = query.from(OthersInfo.class);
			query.select(root);
			Query<OthersInfo> q = session.createQuery(query);
			listOthersInfo =q.getResultList();
			return listOthersInfo;
		}catch(HibernateException e){
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return listOthersInfo;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
	}

}
