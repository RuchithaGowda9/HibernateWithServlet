package com.crimsonlogic.servletwithhibernate.entity;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private static SessionFactory sfactory;

	public static SessionFactory getSessionFactory() {
		if (sfactory == null) {
			synchronized (HibernateUtils.class) {
				if (sfactory == null) {
					try {
						Configuration cfg = new Configuration();
						Properties dbProps = new Properties();
						dbProps.put(Environment.DRIVER, "org.postgresql.Driver");
						dbProps.put(Environment.URL, "jdbc:postgresql://localhost:5432/StudentHibernate");
						dbProps.put(Environment.USER, "postgres");
						dbProps.put(Environment.PASS, "crimson@123");
						dbProps.put(Environment.HBM2DDL_AUTO, "update");
						dbProps.put(Environment.SHOW_SQL, "true");
						dbProps.put(Environment.FORMAT_SQL, "true");
						dbProps.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
						dbProps.put(Environment.NON_CONTEXTUAL_LOB_CREATION, "true"); // Add this line
						cfg.setProperties(dbProps);
						cfg.addAnnotatedClass(StudentInfo.class);

						ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
								.applySettings(cfg.getProperties()).build();
						sfactory = cfg.buildSessionFactory(serviceRegistry);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return sfactory;
	}
}
