package fordonsregister;

import java.io.Serializable;

//Holds getters and setters for Fordon-specific data.

public class Fordon implements Serializable{

	private static final long serialVersionUID = 2L;
	private Person owner;
	private String type;
	private String brand;
	private String regNr;
	
	public Fordon(Person owner, String type, String brand, String regNr) {
		this.owner = owner;
		this.type = type;
		this.brand = brand;
		this.regNr = regNr;
	}
	
	public void setOwner(Person owner) { System.out.println("Fordon.setOwner() executed");
		this.owner = owner;
	}
	
	public Person getOwner() { System.out.println("Fordon.getOwner() executed");
		return owner;
	}
	
	public String getOwnerName() { System.out.println("Fordon.getOwnerName() executed");
		return owner.getName();
	}
	
	public String getOwnerAge() { System.out.println("Fordon.getOwnerAge() executed");
		return owner.getAge();
	}
	
	public void setType(String type) { System.out.println("Fordon.setType() executed");
		this.type = type;
	}
	
	public String getType() { System.out.println("Fordon.getType() executed");
		return type;
	}
	
	public void setBrand(String brand) { System.out.println("Fordon.setBrand() executed");
		this.brand = brand;
	}
	
	public String getBrand() { System.out.println("Fordon.getBrand() executed");
		return brand;
	}
	
	public void setRegNr(String regNr) { System.out.println("Fordon.setRegNr() executed");
		this.regNr = regNr;
	}
	
	public String getRegNr() { System.out.println("Fordon.getRegNr() executed");
		return regNr;
	}

}
