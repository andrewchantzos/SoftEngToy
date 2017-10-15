package persistence.generic;

import java.util.List;

public interface GenericService<E> {

	public List<E> findAll();
	public E findById(int id);
	public void save(E entity);
	public void saveAll(List<E> list);
	
}
