package fordonsregister;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Filehandling {
	
	private Fordonsregister fordonsRegister;
	private ClassRelations relations;
	
	public Filehandling(Fordonsregister fordonsRegister, ClassRelations relations) {
		this.fordonsRegister = fordonsRegister;
		this.relations = relations;
	}
	
	public void setRegister(Fordonsregister uploadedRegister) {
		this.fordonsRegister = uploadedRegister;
	}
	
//pre: expects argument of type "File"
//post: returns "true" if file can be loaded
	public boolean loadFile(File file) { System.out.println("Filehandling.loadFile() executed");
	Fordonsregister uploadedRegister = fordonsRegister.deserializedRegister(file);
		
		if(uploadedRegister != null) {
			relations.setUploadedRegister(uploadedRegister);
			System.out.println("loadfile() returned true");
			return true;
		} else {
			System.out.println("loadfile() returned false");
			return false;
		}
	}

//pre: expects argument of type "File"
//post: returns "true" if file can be saved
	public boolean saveFile(File file) { System.out.println("Filehandling.saveFile() executed");
		Fordonsregister registerToSave = fordonsRegister.serializedRegister();
		try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(file))) {
			write.writeObject(registerToSave);
			return true;
		} catch (IOException ioe) {
			return false;
		}
	}
}
