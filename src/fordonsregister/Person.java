package fordonsregister;

import java.io.Serializable;

//Holds getters and setters for person-specific data.

public class Person implements Serializable{

	private static final long serialVersionUID = 3L;
	private String name;
	private String age;
	
	public Person (String name, String age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) { System.out.println("Person.setName() executed");
		this.name = name;
	}
	
	public String getName() { System.out.println("Person.getName() executed");
		return name;
	}
	
	public void setAge(String age) { System.out.println("Person.setAge() executed");
		this.age = age;
	}
	
	public String getAge() { System.out.println("Person.getAge() executed");
		return age;
	}
}