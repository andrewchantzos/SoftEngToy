package persistence.model;
import model.Person;
import persistence.generic.GenericServiceImpl;

public class PersonService extends GenericServiceImpl<Person>{
	
	public PersonService() {
		super(Person.class);
	}
}
	