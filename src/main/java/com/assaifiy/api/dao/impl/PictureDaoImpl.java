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

import com.assaifiy.api.dao.PictureDao;
import com.assaifiy.api.model.Picture;
import com.assaifiy.api.util.HibernateUtil;

@Repository("pictureDao")
public class PictureDaoImpl implements PictureDao {

	private Session session;
	private Logger LOGGER = LoggerFactory.getLogger(PictureDaoImpl.class);
	@Override
	public boolean save(Picture picture) {
		LOGGER.debug("Save Bike Pictures function being called");
		try{
			LOGGER.warn("Opening Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			LOGGER.warn("Saving new picture : "+picture.getPictureName());
			session.save(picture);
			session.getTransaction().commit();		
			return true;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());		
			return false;
		}
	}

	@Override
	public boolean update(Picture picture) {
		LOGGER.debug("Update Bike Pictures function being called");
		try{
			LOGGER.warn("Opening Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			LOGGER.warn("update new picture : "+picture.getPictureName());
			session.update(picture);
			session.getTransaction().commit();		
			return true;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());		
			return false;
		}
	}

	@Override
	public List<Picture> getAllData(String bikeId) {
		LOGGER.debug("Retrieving bike data");
		List<Picture> listPicture= new ArrayList<>();
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			LOGGER.warn("Retrieving Data");
			CriteriaQuery<Picture> query = builder.createQuery(Picture.class);
			Root<Picture> root = query.from(Picture.class);
			query.select(root);
			Query<Picture> q = session.createQuery(query);
			listPicture =q.getResultList();
			return listPicture;
		}catch(HibernateException e){
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return listPicture;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
	}

}
