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

import com.assaifiy.api.dao.BikeDao;
import com.assaifiy.api.model.Bike;
import com.assaifiy.api.model.OthersInfo;
import com.assaifiy.api.model.Picture;
import com.assaifiy.api.model.SubCategory;
import com.assaifiy.api.util.HibernateUtil;

@Repository("bikeDao")
public class BikeDaoImpl implements BikeDao {
	
	private Session session;
	
	private Logger LOGGER = LoggerFactory.getLogger(BikeDaoImpl.class);
	
	@Override
	public boolean save(Bike bike) {
		LOGGER.debug("Save Bike function being called");
		try{
			LOGGER.warn("Opening Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			LOGGER.warn("Saving new bike : "+bike.getBrand()+"-"+bike.getType()+"-"+bike.getPlateNumber());
			session.save(bike);
			if(bike.getId()>0){
				if(bike.getListOthersInfo().size()>0){
					for(OthersInfo info : bike.getListOthersInfo()){
						info.setBike(bike);
						session.save(info);
					}
				}
				if(bike.getListPicture().size()>0){
					for(Picture pic : bike.getListPicture()){
						pic.setBike(bike);
						session.save(pic);
					}
				}
			}
			session.getTransaction().commit();		
			return true;
		}catch(HibernateException e){
			session.getTransaction().rollback();
			LOGGER.error(e.getMessage());		
			return false;
		}
	}

	@Override
	public boolean update(Bike bike) {
		LOGGER.debug("Update Bike function being called");
		try{
			LOGGER.warn("Opening Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			LOGGER.warn("Update Bike : "+bike.getBrand()+"-"+bike.getType()+"-"+bike.getPlateNumber());
			session.update(bike);
			session.getTransaction().commit();		
			return true;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());		
			return false;
		}
	}

	@Override
	public List<Bike> getAllData() {
		LOGGER.debug("Retrieving bike data");
		List<Bike> listBike = new ArrayList<>();
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			LOGGER.warn("Retrieving Data");
			CriteriaQuery<Bike> query = builder.createQuery(Bike.class);
			Root<Bike> root = query.from(Bike.class);
			query.select(root);
			Query<Bike> q = session.createQuery(query);
			listBike =q.getResultList();
			if(listBike.size()>0){
				for(Bike bike : listBike){
					Hibernate.initialize(bike.getSubCategory());
					Hibernate.initialize(bike.getSubCategory().getCategory());
					for(SubCategory sub : bike.getSubCategory().getCategory().getListSubCategory()){
						Hibernate.initialize(sub);
					}
					if(bike.getListOthersInfo().size()>0){
						for(OthersInfo othersInfo : bike.getListOthersInfo()){
							Hibernate.initialize(othersInfo);
						}
					}
					if(bike.getListPicture().size()>0){
						for(Picture pic : bike.getListPicture()){
							Hibernate.initialize(pic);
						}
					}
					
				}
			}
			return listBike;
		}catch(HibernateException e){
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return listBike;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
	}

	@Override
	public List<Bike> findBySubCategory(String subCategoryCode) {
		List<Bike> listBike = new ArrayList<>();
		LOGGER.debug("Group by sub category function being called");
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			LOGGER.warn("Retrieving Data");
			CriteriaQuery<Bike> query = builder.createQuery(Bike.class);
			Root<Bike> root = query.from(Bike.class);
			query.select(root).where(builder.equal(root.get("subCategory").get("id"), subCategoryCode));
			Query<Bike> q = session.createQuery(query);
			listBike =q.getResultList();
			if(listBike.size()>0){
				for(Bike bike : listBike){
					Hibernate.initialize(bike.getSubCategory());
					Hibernate.initialize(bike.getSubCategory().getCategory());
					for(SubCategory sub : bike.getSubCategory().getCategory().getListSubCategory()){
						Hibernate.initialize(sub);
					}
					if(bike.getListOthersInfo().size()>0){
						for(OthersInfo othersInfo : bike.getListOthersInfo()){
							Hibernate.initialize(othersInfo);
						}
					}
					if(bike.getListPicture().size()>0){
						for(Picture pic : bike.getListPicture()){
							Hibernate.initialize(pic);
						}
					}
					
				}
			}
			return listBike;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());
			return listBike;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
	}

	@Override
	public List<Bike> findByCategory(String categoryCode) {
		List<Bike> listBike = new ArrayList<>();
		LOGGER.debug("Group by category function being called");
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			LOGGER.warn("Retrieving Data");
			CriteriaQuery<Bike> query = builder.createQuery(Bike.class);
			Root<Bike> root = query.from(Bike.class);
			query.select(root).where(builder.equal(root.get("subCategory").get("category").get("id"), categoryCode));
			Query<Bike> q = session.createQuery(query);
			listBike =q.getResultList();
			if(listBike.size()>0){
				for(Bike bike : listBike){
					Hibernate.initialize(bike.getSubCategory());
					Hibernate.initialize(bike.getSubCategory().getCategory());
					for(SubCategory sub : bike.getSubCategory().getCategory().getListSubCategory()){
						Hibernate.initialize(sub);
					}
					if(bike.getListOthersInfo().size()>0){
						for(OthersInfo othersInfo : bike.getListOthersInfo()){
							Hibernate.initialize(othersInfo);
						}
					}
					if(bike.getListPicture().size()>0){
						for(Picture pic : bike.getListPicture()){
							Hibernate.initialize(pic);
						}
					}
					
				}
			}
			return listBike;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());
			return listBike;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
	}

	@Override
	public Bike findByCode(int bikeCode) {
		LOGGER.debug("Retrieving bike data");
		Bike bike = new Bike();
		try{
			LOGGER.warn("Opening Database Session");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			LOGGER.warn("Retrieving Data");
			CriteriaQuery<Bike> query = builder.createQuery(Bike.class);
			Root<Bike> root = query.from(Bike.class);
			query.select(root).where(builder.equal(root.get("id"), bikeCode));
			Query<Bike> q = session.createQuery(query);
			bike =q.getSingleResult();
			Hibernate.initialize(bike.getSubCategory());
			Hibernate.initialize(bike.getSubCategory().getCategory());
			if(bike.getListOthersInfo().size()>0){
				for(SubCategory sub : bike.getSubCategory().getCategory().getListSubCategory()){
					Hibernate.initialize(sub);
				}
				for(OthersInfo othersInfo : bike.getListOthersInfo()){
					Hibernate.initialize(othersInfo);
				}
			}
			if(bike.getListPicture().size()>0){
				for(Picture pic : bike.getListPicture()){
					Hibernate.initialize(pic);
				}
			}
			return bike;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());
			return bike;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
	}

}
