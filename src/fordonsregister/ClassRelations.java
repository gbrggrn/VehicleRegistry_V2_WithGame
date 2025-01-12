package fordonsregister;

//Declares the relationships between all classes except "Person" & "Fordon".
//Also holds the launch()-method.

public class ClassRelations {
	
	private Fordonsregister fordonsRegister;
	private Filehandling fileHandling;
	private BuildGUI buildGUI;
	private Components components;
	private InputValidation inputValidation;
	private Listeners listeners;
	private ButtonLogic buttonLogic;
	
	public ClassRelations () {
		this.fordonsRegister = new Fordonsregister();
		this.inputValidation = new InputValidation();
		this.listeners = new Listeners();
		this.components = new Components();
		this.buildGUI = new BuildGUI(listeners, components, fordonsRegister);
		this.fileHandling = new Filehandling(fordonsRegister, this);
		this.buttonLogic = new ButtonLogic(fordonsRegister, inputValidation, components, buildGUI, fileHandling, this);
		listeners.setButtonLogic(buttonLogic);
		listeners.setFramePanel(buildGUI);
	}
	
	public ButtonLogic getButtonLogic() { System.out.println("ClassRelations.getButtonLogic() executed");
		return this.buttonLogic;
	}
	
	public BuildGUI getFramePanel() { System.out.println("ClassRelations.getFramePanel() executed");
		return this.buildGUI;
	}
	
	public void setUploadedRegister(Fordonsregister uploadedRegister) {System.out.println("ClassRelations.setUploadedRegister() executed");
		this.fordonsRegister = uploadedRegister;
		this.buildGUI.setRegister(uploadedRegister);
		this.fileHandling.setRegister(uploadedRegister);
		this.buttonLogic.setRegister(uploadedRegister);
	}
	
	public void setNewRegister(Fordonsregister newRegister) { System.out.println("ClassRelations.setNewRegister() executed");
		this.fordonsRegister = newRegister;
		this.buildGUI.setRegister(newRegister);
		this.fileHandling.setRegister(newRegister);
		this.buttonLogic.setRegister(newRegister);
	}
	
	public void launch() { System.out.println("ClassRelations.launch() executed");
		buildGUI.buildQuestion();
	}
}