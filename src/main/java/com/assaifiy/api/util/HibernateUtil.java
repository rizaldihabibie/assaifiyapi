package com.assaifiy.api.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);
	private static  final SessionFactory sessionFactory = buildSessionFactory();
		private static SessionFactory buildSessionFactory(){
			InputStream is = null;
			try{
				LOGGER.debug("Building Session Factory");
				is = HibernateUtil.class.getResourceAsStream("/application.properties");
				Properties props = new Properties();
				props.load(is);
				
				return new Configuration().configure("hibernate.cfg.xml").addProperties(props).buildSessionFactory();
			}catch(HibernateException e){
				e.printStackTrace();
				LOGGER.error(e.getMessage());
				throw new ExceptionInInitializerError(e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	
		public static SessionFactory getSessionFactory(){
			return sessionFactory;
		}
		
		public static void shutdown(){
			getSessionFactory().close();
		}
}
