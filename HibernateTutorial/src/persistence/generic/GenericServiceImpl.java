package persistence.generic;
import java.util.List;

public class GenericServiceImpl<E> implements GenericService<E>{

	private GenericDaoImpl<E> dao;

	private Class<? extends E> type;
	
	public GenericServiceImpl(Class<E> type) {
		this.type = type;
		dao = new GenericDaoImpl<E>(type);
	}
	
	public Class<? extends E> getType() {
		return type;
	}


	public GenericDaoImpl<E> getDao() {
		return dao;
	}

	public void setDao(GenericDaoImpl<E> dao) {
		this.dao = dao;
	}

	public void save(E entity) {
		dao.openCurrentSessionwithTransaction();
		dao.save(entity);
		dao.closeCurrentSessionwithTransaction();
	}
	
	public void saveAll(List<E> list) {
		dao.openCurrentSessionwithTransaction();
		dao.saveAll(list);
		dao.closeCurrentSessionwithTransaction();
	}

	
	public E findById(int id) {
		dao.openCurrentSession();
		E e = dao.findById(id);
		dao.closeCurrentSession();
		return e;
	}

	public List<E> findAll() {
		dao.openCurrentSession();
		List<E> list = dao.findAll();
		dao.closeCurrentSession();
		return list;
	}
}

