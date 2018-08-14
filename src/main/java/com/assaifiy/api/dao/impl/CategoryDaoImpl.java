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

import com.assaifiy.api.dao.CategoryDao;
import com.assaifiy.api.model.Category;
import com.assaifiy.api.model.SubCategory;
import com.assaifiy.api.util.HibernateUtil;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	private Session session;
	private Logger LOGGER = LoggerFactory.getLogger(CategoryDaoImpl.class);
	
	@Override
	public boolean save(Category category) {
		LOGGER.debug("Save function being called");
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			LOGGER.warn("Saving new category : "+category.getCategoryName());
			session.save(category);
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
	public boolean update(Category category) {
		LOGGER.debug("update function being called");
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			LOGGER.warn("Saving new category : "+category.getCategoryName());
			session.update(category);
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
	public List<Category> getAllData() {
		LOGGER.debug("Retrieving category data");
		List<Category> listCategory = new ArrayList<>();
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			LOGGER.warn("Retrieving Data");
			CriteriaQuery<Category> query = builder.createQuery(Category.class);
			Root<Category> root = query.from(Category.class);
			query.select(root).where(builder.equal(root.get("status"),"ACTIVE"));
			Query<Category> q = session.createQuery(query);
			listCategory =q.getResultList();
			for(Category cat : listCategory){
				for(SubCategory sub : cat.getListSubCategory()){
					Hibernate.initialize(sub);
				}
			}
			return listCategory;
		}catch(HibernateException e){
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return listCategory;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
	}

	@Override
	public Category findByCode(String categoryCode) {
		Category category = new Category();
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			LOGGER.warn("Retrieving Data");
			CriteriaQuery<Category> query = builder.createQuery(Category.class);
			Root<Category> root = query.from(Category.class);
			query.select(root).where(builder.equal(root.get("categoryCode"), categoryCode));
			Query<Category> q = session.createQuery(query);
			category =q.getSingleResult();
			for(SubCategory sub : category.getListSubCategory()){
				Hibernate.initialize(sub);
			}
			return category;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());
			return category;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
	}

	@Override
	public List<SubCategory> listSubCategory(String categoryCode) {
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
			query.select(root).where(builder.equal(root.get("category").get("id"), categoryCode));
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

	@Override
	public boolean delete(Category category) {
		LOGGER.debug("Delete function being called");
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			LOGGER.warn("Deleting category : "+category.getCategoryName());
			session.delete(category);
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

}
