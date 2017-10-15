package persistence.generic;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GenericDaoImpl<T> implements GenericDao<T> {

	private Class<? extends T> type;
	
	private Session currentSession;

	private Transaction currentTransaction;
	
	public GenericDaoImpl() {
	}
	
	public GenericDaoImpl(Class<T> type) { 
		this.type = type; 
	}
	
	public Class<? extends T> getType() {
		return type;
	}

	public void setType(Class<? extends T> type) {
		this.type = type;
	}


	public SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = HibernateFactory.buildSessionFactory();
		return sessionFactory;
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	
	public void save(T entity) {
		getCurrentSession().save(entity);
	}


	public T findById(Integer id) {
		return (T) getCurrentSession().get(type, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> list = (List<T>) getCurrentSession()
				.createCriteria(type).list();
		return list;
	}
	
	public void saveAll(List<T> list) {
		for(T obj : list) {
			 getCurrentSession().save(obj);
		}
	}

}
