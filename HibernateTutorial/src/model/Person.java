package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="PERSON_ID")
	private int id;	

	@Column(name="age")
	private Integer age;
	
	@Column(name="name")
	private String name;

	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
