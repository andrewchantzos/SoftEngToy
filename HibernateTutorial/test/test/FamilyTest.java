package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Family;
import model.Person;
import persistence.model.FamilyService;

public class FamilyTest {

	@Test
	public void test() {

		Person person1 = new Person();
		person1.setAge(20);
		person1.setName("Andreas");
		
		Person person2 = new Person();
		person2.setAge(22);
		person2.setName("Goumas");
		
		List<Person> people = new ArrayList<>();
		
		people.add(person1);
		people.add(person2);
		
		Family family = new Family();
		
		family.setPeople(people);
		
		FamilyService fs = new FamilyService();
		fs.save(family);
	}
}
