package persistence.generic;

import java.util.List;

public interface GenericDao<T> {

	public List<T> findAll();
	public T findById(Integer id);
	public void save(T entity);
	public void saveAll(List<T> list);
}
