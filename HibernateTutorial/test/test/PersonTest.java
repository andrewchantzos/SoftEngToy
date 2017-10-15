package test;

import org.junit.Test;

import model.Person;
import persistence.model.PersonService;

public class PersonTest {

	@Test
	public void test() {
		Person person = new Person();
		person.setAge(20);
		person.setName("Andreas");
		
		PersonService ps = new PersonService();
		
		ps.save(person);
	}

}
