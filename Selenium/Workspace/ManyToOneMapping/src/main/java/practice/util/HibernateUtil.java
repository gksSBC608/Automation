package practice.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import prac.exceptions.UtilException;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static Session getHibernateSession() throws UtilException {
		try {
			if (sessionFactory == null) {
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
				System.out.println("Successfully built Session Factory");
			}

			return sessionFactory.openSession();

		} catch (Exception ex) {
			throw new UtilException(ex);
		}
	}

}
