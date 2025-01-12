package fordonsregister;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Fordonsregister implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int currentSize;							//int currentSize holds the current size of the registry
	private int maxSize;								//int maxSize holds the max size of the registry
	private LinkedList<Fordon> fordonList;			//initializes a variable fordonList of type linked list.
	
	public Fordonsregister() {
		this.currentSize = 0;							//sets currentSize to 0.
		this.fordonList = new LinkedList<>();			//creates a new instance of fordonList to hold fordon
	}
	
//size() returns currentSize.
		public int getCurrentSize() { System.out.println("Fordonsregister.getCurrentSize() executed");
			return currentSize;
		}
		
		public void setCurrentSize(int size) { System.out.println("Fordonsregister.setCurrentSize() executed");
			this.currentSize = size;
		}
		
		public int addToCurrentSize() { System.out.println("Fordonsregister.addToCurrentSize() executed");
			return ++ currentSize;
		}
		
//maxSize() returns maxSize.
		public int getMaxSize() { System.out.println("Fordonsregister.getMaxSize() executed");
			return maxSize;
		}
		
//setMaxSize(): setter method for maxSize.
		public void setMaxSize(int maxSize) { System.out.println("Fordonsregister.setMaxSize() executed");
			this.maxSize = maxSize;
		}
		
//getFordonList() returns the current fordonList.
		public List<Fordon> getFordonList() { System.out.println("Fordonsregister.getFordonList() executed");
			return fordonList;
		}
	
//setFordonList() is used if a user uploads an old list
		public void setFordonList(LinkedList<Fordon> fordonList){ System.out.println("Fordonsregister.setFordonList() executed");
			this.fordonList = fordonList;
		}
	
//pre: all arguments are of correct type and format
//post: fordon added or registry full
	public boolean addFordon(Person owner, String type, String brand, String regNr) { System.out.println("Fordonsregister.addFordon() executed");
		if(currentSize < maxSize) {
			Fordon fordon = new Fordon(owner, type, brand, regNr);
			fordonList.add(fordon);
			currentSize++;
			return true;
		} else {
			//System.out.println("Fordonsregister fullt!\n");
			return false;
		}
	}
	
//pre: input is a valid int
//post: removes vehicle or prompts for new "pos"
	public boolean removeFordon(int pos) { System.out.println("Fordonsregister.removeFordon() executed");
		if(pos >= 0 && pos < fordonList.size()) {
			fordonList.remove(pos);
			currentSize--;
			return true;
		} else {
			return false;
		}
	}
	
//pre: input is valid int
//post: information from specific index point is returned, if it does not exist; return: null
	public Fordon getFordon(int pos) { System.out.println("Fordonsregister.getFordon() executed");
		if(pos >= 0 && pos < fordonList.size()) {
			return fordonList.get(pos);
		} else {
			return null;
		}
	}
	
//pre: input is valid int
//post: no fordon is found at "pos": returns to menu or returns "utskrift" as formatted string
	public String skrivUt(int pos) { System.out.println("Fordonsregister.skrivUt() executed");
		StringBuilder utskrift = new StringBuilder();
		Fordon fordon = getFordon(pos);
		
		if(fordon != null) {
			utskrift.append("Position: ").append(pos).append("\n");
			utskrift.append("Ägare: ").append(fordon.getOwnerName()).append("\n");
			utskrift.append("Ålder: ").append(fordon.getOwnerAge()).append("\n");
			utskrift.append("Typ: ").append(fordon.getType()).append("\n");
			utskrift.append("Märke: ").append(fordon.getBrand()).append("\n");
			utskrift.append("Registreringsnummer: ").append(fordon.getRegNr()).append("\n");
		} else {
			utskrift.append("1");
			return utskrift.toString();
		}
			
		return utskrift.toString();
	}
	
//builds a string and returns it to caller method (which would be a print-method)
	public String skrivUtAllt() { System.out.println("Fordonsregister.skrivUtAllt() executed");
		StringBuilder utskrift = new StringBuilder();
		List<Fordon> fordonList = getFordonList();
		
		for(int i=0; i<fordonList.size(); i++) {
			Fordon fordon = fordonList.get(i);
			utskrift.append("Position:").append(i).append("\n");
			utskrift.append("Ägare: ").append(fordon.getOwnerName()).append("\n");
			utskrift.append("Ålder: ").append(fordon.getOwnerAge()).append("\n");
			utskrift.append("Typ: ").append(fordon.getType()).append("\n");
			utskrift.append("Märke: ").append(fordon.getBrand()).append("\n");
			utskrift.append("Registreringsnummer: ").append(fordon.getRegNr()).append("\n\n");
		}
		
		return utskrift.toString();
	}
	
//returns the current serialized instance of this class to caller
	public Fordonsregister serializedRegister() { System.out.println("Fordonsregister.serializeRegister() executed");
		return this;
	}

//pre: Valid argument file of type "File"
//post: returns deserialized register of type ModelFordonsregister from file
	public Fordonsregister deserializedRegister(File file) { System.out.println("Fordonsregister.deSerializedRegister() executed");
		Fordonsregister deserializedRegister;
		deserializedRegister = null;
		
		try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(file))) {
			deserializedRegister = (Fordonsregister) read.readObject();
			System.out.println("deserializedRegister successful");
		} catch (IOException | ClassNotFoundException ioecnfe) {
			ioecnfe.printStackTrace();
			System.out.println("deserializedRegister failed");
		}
		
		return deserializedRegister;
	}
}