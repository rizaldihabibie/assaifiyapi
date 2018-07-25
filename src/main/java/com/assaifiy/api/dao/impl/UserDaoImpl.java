package com.assaifiy.api.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.assaifiy.api.dao.UserDao;
import com.assaifiy.api.model.UserModel;
import com.assaifiy.api.util.HibernateUtil;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private Session session;
	
	private Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
	@Override
	public UserModel findByUsername(String username) {
		
		LOGGER.debug("Retrieving bike data");
		UserModel user = new UserModel();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			LOGGER.warn("Retrieving Data");
			CriteriaQuery<UserModel> query = builder.createQuery(UserModel.class);
			Root<UserModel> root = query.from(UserModel.class);
			query.select(root).where(builder.equal(root.get("userEmail"), username));
			Query<UserModel> q = session.createQuery(query);
			user =q.getSingleResult();
			return user;
		}catch(HibernateException e){
			LOGGER.error(e.getMessage());
			return user;
		}finally{
			if(session != null){
				LOGGER.warn("Closing session");
				session.close();
			}
		}
		// TODO Auto-generated method stub
	}

}
