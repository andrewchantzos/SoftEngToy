package persistence.generic;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateFactory.sessionFactory = sessionFactory;
	}

	public static void closeFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

	public static SessionFactory buildSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}

}
