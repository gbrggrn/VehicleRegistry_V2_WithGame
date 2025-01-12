package fordonsregister;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

//Holds the logic for all buttons.

public class ButtonLogic {
	
	private Fordonsregister fordonsRegister;
	private InputValidation inputValidation;
	private Components components;
	private BuildGUI buildGUI;
	private Filehandling fileHandling;
	private ClassRelations relations;
	
	public ButtonLogic(Fordonsregister fordonsRegister, InputValidation inputValidation, Components components, BuildGUI buildGUI, Filehandling fileHandling, ClassRelations relations) {
		this.fordonsRegister = fordonsRegister;
		this.inputValidation = inputValidation;
		this.components = components;
		this.buildGUI = buildGUI;
		this.fileHandling = fileHandling;
		this.relations = relations;
	}
	
	public void setRegister(Fordonsregister uploadedRegister) {
		this.fordonsRegister = uploadedRegister;
	}
	
	public void playGameButtonLogic() {
		SwingUtilities.invokeLater(() -> {
	        new FordonGame().start();
	    });
	}
	
	public void loadButtonLogic() { System.out.println("ButtonLogic.loadButtonLogic() executed");
		JFileChooser fileChooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Ser files (*.ser)", "ser");
		
		fileChooser.setFileFilter(filter);
		
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
		
		fileChooser.setDialogTitle("Öppna Fordonsregister");
		
		int choice = fileChooser.showOpenDialog(null);
		
		if(choice == JFileChooser.APPROVE_OPTION) {
			System.out.println("Fil vald");
			File selectedFile = fileChooser.getSelectedFile();
			
			if(fileHandling.loadFile(selectedFile) == true) {
				buildGUI.getQuestion().setVisible(false);
				try {
					buildGUI.getMainFrame().setVisible(false);
				} catch (NullPointerException npe) {
					
				}
				buildGUI.buildUI();
			} else {
				JOptionPane.showMessageDialog(null, "Något gick fel!", "Problem", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
	public void saveButtonLogic() { System.out.println("ButtonLogic.saveButtonLogic() executed");
		
		if(fordonsRegister.getCurrentSize() < 1) {
			components.printToPrintField("--- Kan inte spara ett tomt register! ---");
			return;
		}
		
		JFileChooser fileChooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Ser files (*.ser)", "ser");
		
		fileChooser.setFileFilter(filter);
		
		fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
		
		fileChooser.setDialogTitle("Spara Fordonsregister");
		
		int choice = fileChooser.showSaveDialog(null);
		
		if(choice == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			
			if(fileHandling.saveFile(selectedFile) == true) {
				System.out.println("Fil sparad");
			} else {
				JOptionPane.showMessageDialog(null, "Något gick fel!", "Problem", JOptionPane.ERROR_MESSAGE);
			}
			
		} else if (choice == JFileChooser.CANCEL_OPTION) {
			System.out.println("Cancel option");
		}
	}
	
	public void exitButtonLogic() { System.out.println("ButtonLogic.exitButtonLogic() executed");
		int choice = JOptionPane.showConfirmDialog(null, "Vill du avsluta programmet?\nRegister som inte sparats förloras", "Avsluta?", 2);
		
		if(choice == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}
	
	public void clearButtonLogic() { System.out.println("ButtonLogic.clearButtonLogic() executed");
		components.clearPrintField();
	}
	
	public void sizeButtonLogic() { System.out.println("ButtonLogic.sizeButtonLogic() executed");
		String sizeText = components.getSizeText();
		
		if(sizeText == null || inputValidation.checkInputIntString(sizeText) == false) {
			buildGUI.getFirstFrame().setVisible(false);
			buildGUI.buildSetRegisterSize();
		} else {
			int sizeTextInt = Integer.parseInt(sizeText);
			if(sizeTextInt < 1) {
				buildGUI.getFirstFrame().setVisible(false);
				buildGUI.buildSetRegisterSize();
			} else {
				fordonsRegister.setMaxSize(sizeTextInt);
				buildGUI.getFirstFrame().setVisible(false);
				buildGUI.buildUI();
			}
		}
	}
	
	public void addButtonLogic() { System.out.println("ButtonLogic.addButtonLogic() executed");
		String typeText = components.getTypeText();
		String brandText = components.getBrandText();
		String regNrText = components.getRegNrText();
		String ownerNameText = components.getOwnerNameText();
		String ownerAgeText = components.getOwnerAgeText();
		boolean validInput = true;
		
		if(typeText == null || inputValidation.checkInputString(typeText) == false) {
			components.printToPrintField("--- Felaktig eller ingen typ angedd ---");
			validInput = false;
			components.clearSpecificField(components.getTypeField());
		}
		
		if(brandText == null || inputValidation.checkInputString(brandText) == false) {
			components.printToPrintField("--- Felaktig eller inget märke angett ---");
			validInput = false;
			components.clearSpecificField(components.getBrandField());
		}
		
		if(regNrText == null || inputValidation.checkInputRegNr(regNrText) == false) {
			components.printToPrintField("--- Inget eller felaktigt registreringsnummer ---");
			validInput = false;
			components.clearSpecificField(components.getRegNrField());
		}
		
		if(ownerNameText == null || inputValidation.checkInputString(ownerNameText) == false) {
			components.printToPrintField("--- Inget eller felaktigt namn angett ---");
			validInput = false;
			components.clearSpecificField(components.getOwnerNameField());
		}
		
		if(ownerAgeText == null || inputValidation.checkInputIntString(ownerAgeText) == false) {
			components.printToPrintField("--- Ingen ålder angedd eller felaktigt format ---");
			validInput = false;
			components.clearSpecificField(components.getOwnerAgeField());
		}
		
		if(validInput == true) {
			Person owner = new Person(ownerNameText, ownerAgeText);
			if(fordonsRegister.addFordon(owner, typeText, brandText, regNrText) == true) {
				components.printToPrintField("--- Fordon tillagt i registret! ---\n");
				components.printToCurrentSizeCount(fordonsRegister.getCurrentSize());
				components.clearAllFields();
			} else {
				components.printToPrintField("--- Fordonsregister fullt! ---\n");
				components.clearAllFields();
			}
		} else {
			components.printToPrintField("--- Kunde inte spara fordon ---\n");
		}
	}
	
	public void removeButtonLogic() { System.out.println("ButtonLogic.removeButtonLogic() executed");
		String removePosString = components.getPosText();
		
		if(removePosString == null || inputValidation.checkInputIntString(removePosString) == false) {
			components.printToPrintField("--- Fel format. Försök igen ---");
			buildGUI.getThirdFrame().setVisible(false);
		} else {
			int removePosInt = Integer.parseInt(removePosString);
			if(fordonsRegister.removeFordon(removePosInt) == false) {
				components.printToPrintField("--- Inget fordon på positionen. Försök igen ---");
				components.printToPrintField("--- Fordon finns på position 0-" + fordonsRegister.getCurrentSize() + " ---\n");
				buildGUI.getThirdFrame().setVisible(false);
			} else {
				components.printToPrintField("--- Fordon på postion " + removePosInt + " raderat. ---");
				components.printToCurrentSizeCount(fordonsRegister.getCurrentSize());
				buildGUI.getThirdFrame().setVisible(false);
			}
		}
	}
	
	public void searchButtonLogic() { System.out.println("ButtonLogic.searchButtonLogic() executed");
		String searchPosString = components.getPosText();
		
		if(searchPosString == null || inputValidation.checkInputIntString(searchPosString) == false) {
			components.printToPrintField("--- Fel format! Försök igen ---");
			buildGUI.getSecondFrame().setVisible(false);
		} else {
			int searchPosInt = Integer.parseInt(searchPosString);
			String isValid = fordonsRegister.skrivUt(searchPosInt);
			
			if(fordonsRegister.getCurrentSize() == 0) {
				components.printToPrintField("--- Det finns inga fordon i registret ---");
				buildGUI.getSecondFrame().setVisible(false);
			} else if(searchPosInt < 0 || searchPosInt > fordonsRegister.getMaxSize()) {
				components.printToPrintField("--- Den positionen finns inte i registret. ---\n");
				buildGUI.getSecondFrame().setVisible(false);
			} else if(inputValidation.checkInputIntString(isValid) == true) {
				components.printToPrintField("--- Den positionen är tom! ---\n");
				components.printToPrintField("--- Data finns på position 0-" + fordonsRegister.getCurrentSize() + " ---\n");
				buildGUI.getSecondFrame().setVisible(false);
			} else {
				components.printToPrintField(isValid);
				buildGUI.getSecondFrame().setVisible(false);
			}
		}
	}
	
	public void printButtonLogic() { System.out.println("ButtonLogic.printButtonLogic() executed");
		components.clearPrintField();
		if(fordonsRegister.getCurrentSize() != 0) {
			String printText = fordonsRegister.skrivUtAllt();
			components.printToPrintField("\n" + printText);
		} else {
			components.printToPrintField("--- Inga registrerade fordon ---");
		}
	}
	
	public void newItemButtonLogic() { System.out.println("ButtonLogic.newItemButtonLogic() executed");
		int choice = JOptionPane.showConfirmDialog(null, "Vill du starta ett nytt register?\nRegister som inte sparats kommer förloras", "Nytt register", 2);
		
		if(choice == JOptionPane.OK_OPTION) {
			Fordonsregister newRegister = new Fordonsregister();
			relations.setNewRegister(newRegister);
			buildGUI.getMainFrame().setVisible(false);
			buildGUI.buildSetRegisterSize();
		}
	}
}