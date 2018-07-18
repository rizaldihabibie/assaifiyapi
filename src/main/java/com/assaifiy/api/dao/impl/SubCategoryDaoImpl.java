package com.assaifiy.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.assaifiy.api.dao.SubCategoryDao;
import com.assaifiy.api.model.SubCategory;
import com.assaifiy.api.util.HibernateUtil;

@Repository("subCategoryDao")
public class SubCategoryDaoImpl implements SubCategoryDao{

	private Session session;
	private Logger LOGGER = LoggerFactory.getLogger(SubCategoryDaoImpl.class);
	@Override
	public boolean save(SubCategory subCategory) {
		LOGGER.debug("Save function being called");
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			LOGGER.warn("Saving new sub category : "+subCategory.getSubCategoryName());
			session.save(subCategory);
			session.getTransaction().commit();
			return true;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());
			return false;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
	}

	@Override
	public boolean update(SubCategory subCategory) {
		LOGGER.debug("Save function being called");
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			LOGGER.warn("Saving new sub category : "+subCategory.getSubCategoryName());
			session.update(subCategory);
			session.getTransaction().commit();
			return true;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());
			return false;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}

	}

	@Override
	public boolean delete(SubCategory subCategory) {
		LOGGER.debug("Save function being called");
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			LOGGER.warn("Saving new sub category : "+subCategory.getSubCategoryName());
			session.delete(subCategory);
			session.getTransaction().commit();
			return true;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());
			return false;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
	}

	@Override
	public SubCategory findByCode(String subCategoryCode) {
		SubCategory subCategory = new SubCategory();
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			LOGGER.warn("Retrieving Data");
			CriteriaQuery<SubCategory> query = builder.createQuery(SubCategory.class);
			Root<SubCategory> root = query.from(SubCategory.class);
			query.select(root).where(builder.equal(root.get("subCategoryCode"), subCategoryCode));
			Query<SubCategory> q = session.createQuery(query);
			subCategory=q.getSingleResult();
			if(subCategory.getSubCategoryCode() != null){
				Hibernate.initialize(subCategory.getCategory());
			}
			return subCategory;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());
			return subCategory;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
	}

	@Override
	public List<SubCategory> getAllData() {
		LOGGER.debug("Retrieving category data");
		List<SubCategory> listSubCategory = new ArrayList<>();
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			LOGGER.warn("Retrieving Data");
			CriteriaQuery<SubCategory> query = builder.createQuery(SubCategory.class);
			Root<SubCategory> root = query.from(SubCategory.class);
			query.select(root);
			Query<SubCategory> q = session.createQuery(query);
			listSubCategory =q.getResultList();
			if(listSubCategory.size()>0){
				for(SubCategory sub : listSubCategory){
					Hibernate.initialize(sub.getCategory());
				}
			}
			return listSubCategory;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());
			return listSubCategory;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
	}

}
