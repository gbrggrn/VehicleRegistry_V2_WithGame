package fordonsregister;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Holds methods to create different components. Buttons, TextFields and TextArea.

public class Components {
	
//Buttons
	private JButton newRegisterButton;
	private JButton playGameButton;
	private JButton uploadButton;
	private JButton sizeButton;
	private JButton addButton;
	private JButton removeButton;
	private JButton printButton;
	private JButton searchPosButton;
	private JButton saveButton;
	private JButton exitButton;
	private JButton clearButton;
	private JButton searchActualButton;
	private JButton removeActualButton;
	
	public JButton newRegisterButton(Listeners listeners) { System.out.println("Components.newRegisterButton() executed");
		newRegisterButton = new JButton();
		
		newRegisterButton.setText("Nytt register");
		newRegisterButton.addActionListener(listeners);
		newRegisterButton.setActionCommand("newRegister");
		
		return newRegisterButton;
	}
	
	public JButton playGameButton(Listeners listeners) { System.out.println("Components.playGameButton() executed");
		playGameButton = new JButton();
		
		playGameButton.setText("Spela spel");
		playGameButton.addActionListener(listeners);
		playGameButton.setActionCommand("playGame");
		
		return playGameButton;
	}
	
	public JButton uploadButton(Listeners listeners) { System.out.println("Components.uploadButton() executed");
		uploadButton = new JButton();
		
		uploadButton.setText("Ladda upp");
		uploadButton.addActionListener(listeners);
		uploadButton.setActionCommand("upload");
		
		return uploadButton;
	}
	
	public JButton sizeButton(Listeners listeners) { System.out.println("Components.sizeButton() executed");
		sizeButton = new JButton();
		
		sizeButton.setText("Spara");
		sizeButton.addActionListener(listeners);
		sizeButton.setActionCommand("size");
		
		return sizeButton;
	}
	
	public JButton addButton(Listeners listeners) { System.out.println("Components.addButton() executed");
		addButton = new JButton();
		
		addButton.setText("Lägg till");
		addButton.addActionListener(listeners);
		addButton.setActionCommand("add");
		
		return addButton;
	}
	
	public JButton removeButton(Listeners listeners) { System.out.println("Components.removeButton() executed");
		removeButton = new JButton();
		
		removeButton.setText("Ta bort");
		removeButton.addActionListener(listeners);
		removeButton.setActionCommand("remove");
		
		return removeButton;
	}
	
	public JButton printButton(Listeners listeners) { System.out.println("Components.printButton() executed");
		printButton = new JButton();
		
		printButton.setText("Skriv ut allt");
		printButton.addActionListener(listeners);
		printButton.setActionCommand("print");
		
		return printButton;
	}
	
	public JButton searchPosButton (Listeners listeners) { System.out.println("Components.searchPosButton() executed");
		searchPosButton = new JButton();
		
		searchPosButton.setText("Sök position");
		searchPosButton.addActionListener(listeners);
		searchPosButton.setActionCommand("search");
		
		return searchPosButton;
	}
	
	public JButton saveButton(Listeners listeners) { System.out.println("Components.saveButton() executed");
		saveButton = new JButton();
		
		saveButton.setText("Spara");
		saveButton.addActionListener(listeners);
		saveButton.setActionCommand("saveAll");
		
		return saveButton;
	}
	
	public JButton exitButton(Listeners listeners) { System.out.println("Components.exitButton() executed");
		exitButton = new JButton();
		
		exitButton.setText("Avsluta");
		exitButton.addActionListener(listeners);
		exitButton.setActionCommand("exit");
		
		return exitButton;
	}
	
	public JButton clearButton(Listeners listeners) {
		clearButton = new JButton();
		
		clearButton.setText("Rensa");
		clearButton.addActionListener(listeners);
		clearButton.setActionCommand("clear");
		
		return clearButton;
	}
	
	public JButton searchActualButton(Listeners listeners) { System.out.println("Components.searchActualButton() executed");
		searchActualButton = new JButton();
		
		searchActualButton.setText("Sök position");
		searchActualButton.addActionListener(listeners);
		searchActualButton.setActionCommand("searchActual");
		
		return searchActualButton;
	}
	
	public JButton removeActualButton(Listeners listeners) { System.out.println("Components.removeActualButton() executed");
		removeActualButton = new JButton();
		
		removeActualButton.setText("Radera fordon");
		removeActualButton.addActionListener(listeners);
		removeActualButton.setActionCommand("removeActual");
		
		return removeActualButton;
	}
	
//Fields
	private JTextField posText;
	private JTextField typeText;
	private JTextField brandText;
	private JTextField regNrText;
	private JTextField ownerNameText;
	private JTextField ownerAgeText;
	private JTextField sizeText;
	
	public void clearSpecificField(JTextField textField) {
		textField.setText("");
	}
	
	public void clearAllFields() { System.out.println("Components.clearAllField() executed");
	typeText.setText("");
	brandText.setText("");
	regNrText.setText("");
	ownerNameText.setText("");
	ownerAgeText.setText("");
}
	
	public JPanel sizeField() { System.out.println("Components.sizeField() executed");
		JPanel sizeField = new JPanel();
		sizeText = new JTextField(15);
		JLabel sizeFieldLabel = new JLabel("Ange storlek på registret:");
		
		sizeField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		sizeField.add(sizeFieldLabel);
		sizeField.add(sizeText);
		
		return sizeField;
	}
	
	public String getSizeText() { System.out.println("Components.getSizeText() executed");
		return sizeText.getText();
	}
	
	public JPanel posField() { System.out.println("Components.posField() executed");
		JPanel posField = new JPanel();
		posText = new JTextField(15);
		JLabel posFieldLabel = new JLabel("Ange position:");
		
		posField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		posField.add(posFieldLabel);
		posField.add(posText);
		
		return posField;
	}
	
	public String getPosText() { System.out.println("Components.getPosText() executed");
		return posText.getText();
	}
	
	public void clearPosField() { System.out.println("Components.clearPosField() executed");
		posText.setText("");
	}
	
	
	public JPanel typeField() { System.out.println("Components.typeField() executed");
		JPanel typeField = new JPanel();
		typeText = new JTextField(15);
		JLabel typeFieldLabel = new JLabel("Ange typ:");
		
		typeField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		typeField.add(typeFieldLabel);
		typeField.add(typeText);
		
		return typeField;
	}
	
	public String getTypeText() { System.out.println("Components.getTypeText() executed");
		return typeText.getText();
	}
	
	public JTextField getTypeField() {
		return typeText;
	}
	
	public JPanel brandField() { System.out.println("Components.brandField() executed");
		JPanel brandField = new JPanel();
		brandText = new JTextField(15);
		JLabel brandFieldLabel = new JLabel("Ange märke:");
		
		brandField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		brandField.add(brandFieldLabel);
		brandField.add(brandText);
		
		return brandField;
	}
	
	public String getBrandText() { System.out.println("Components.getBrandText() executed");
		return brandText.getText();
	}
	
	public JTextField getBrandField() {
		return brandText;
	}
	
	
	public JPanel regNrField() { System.out.println("Components.regNrField() executed");
		JPanel regNrField = new JPanel();
		regNrText = new JTextField(15);
		JLabel regNrFieldLabel = new JLabel("Ange regNr XYZ-123:");
		
		regNrField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		regNrField.add(regNrFieldLabel);
		regNrField.add(regNrText);
		
		return regNrField;
	}
	
	public String getRegNrText() { System.out.println("Components.getRegNrText() executed");
		return regNrText.getText();
	}
	
	public JTextField getRegNrField() {
		return regNrText;
	}
	
	
	public JPanel ownerNameField() { System.out.println("Components.ownerNameField() executed");
		JPanel ownerNameField = new JPanel();
		ownerNameText = new JTextField(15);
		JLabel ownerNameFieldLabel = new JLabel("Ägares namn:");
		
		ownerNameField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		ownerNameField.add(ownerNameFieldLabel);
		ownerNameField.add(ownerNameText);
		
		return ownerNameField;
	}
	
	public String getOwnerNameText() { System.out.println("Components.getOwnerNameText() executed");
		return ownerNameText.getText();
	}
	
	public JTextField getOwnerNameField() {
		return ownerNameText;
	}
	
	
	public JPanel ownerAgeField() { System.out.println("Components.ownerAgeField() executed");
		JPanel ownerAgeField = new JPanel();
		ownerAgeText = new JTextField(15);
		JLabel ownerAgeFieldLabel = new JLabel("Ägares ålder:");
		
		ownerAgeField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		ownerAgeField.add(ownerAgeFieldLabel);
		ownerAgeField.add(ownerAgeText);
		
		return ownerAgeField;
	}
	
	public String getOwnerAgeText() { System.out.println("Components.getOwnerAgeText() executed");
		return ownerAgeText.getText();
	}
	
	public JTextField getOwnerAgeField() {
		return ownerAgeText;
	}
	
	public JPanel currentSizeCount() { System.out.println("Components.currentSizeCount() executed");
		JPanel currentSizeField = new JPanel();
		currentSizeText = new JTextField(5);
		JLabel currentSizeLabel = new JLabel("Registrerade fordon:");
		
		currentSizeText.setEditable(false);
		
		currentSizeField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		currentSizeField.add(currentSizeLabel);
		currentSizeField.add(currentSizeText);
		
		return currentSizeField;
	}
	
	public void printToCurrentSizeCount(int currentSizeCount) { System.out.println("Components.printToCurrentSizeCount() executed");
		currentSizeText.setText(Integer.toString(currentSizeCount));
	}
	
	public void clearCurrentSizeCount() { System.out.println("Components.clearCurrentSizeCount() executed");
		currentSizeText.setText("");
	}
	
	public JPanel maxSizeCount() { System.out.println("Components.maxSizeCount() executed");
		JPanel maxSizeField = new JPanel();
		maxSizeText = new JTextField(5);
		JLabel maxSizeLabel = new JLabel("Platser i registret:");
		
		maxSizeText.setEditable(false);
		
		maxSizeField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		maxSizeField.add(maxSizeLabel);
		maxSizeField.add(maxSizeText);
		
		return maxSizeField;
	}
	
	public void printToMaxSizeCount(int maxSizeCount) { System.out.println("Components.printToMaxSizeCount() executed");
		maxSizeText.setText(Integer.toString(maxSizeCount));
	}
	
	public void clearMaxSizeCount() { System.out.println("Components.clearMaxSizeCount() executed");
		maxSizeText.setText("");
	}
	
//TextArea
	public JTextArea printText;
	public JTextField currentSizeText;
	public JTextField maxSizeText;
	
	public JPanel printField() { System.out.println("Components.printField() executed");
		JPanel printField = new JPanel();
		printText = new JTextArea(30, 44);
		JScrollPane printFieldScroll = new JScrollPane(printText);
		
		printText.setEditable(false);
		
		printField.add(printFieldScroll);
		
		return printField;
	}
	
	public void printToPrintField(String text) { System.out.println("Components.printToPrintField() executed");
		printText.append(text + "\n");
	}
	
	public void clearPrintField() { System.out.println("Components.clearPrintField() executed");
		printText.setText("");
	}
}