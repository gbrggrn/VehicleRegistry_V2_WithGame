package fordonsregister;

import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

//Holds methods to create the basic Frames and Panels as well as methods for building the GUI.

@SuppressWarnings("serial")
public class BuildGUI extends JFrame {
	
	private Listeners listeners;
	private Components components;
	private Fordonsregister fordonsRegister;

	public BuildGUI(Listeners listeners, Components components, Fordonsregister fordonsRegister) {
		this.listeners = listeners;
		this.components = components;
		this.fordonsRegister = fordonsRegister;
	}
	
	public void setRegister(Fordonsregister uploadedRegister) {
		this.fordonsRegister = uploadedRegister;
	}
	
//Frames and Panels
	public JFrame buildMainFrame() { System.out.println("BuildGUI.buildMainFrame() executed");
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(442,818);
		mainFrame.setTitle("Fordonsregister");
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		
		return mainFrame;
	}
	
	public JFrame secondaryFrame() { System.out.println("BuildGUI.secondaryFrame() executed");
		JFrame secondaryFrame = new JFrame();
		secondaryFrame.setSize(410,100);
		secondaryFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		secondaryFrame.setResizable(false);
		secondaryFrame.setLocationRelativeTo(null);
		
		return secondaryFrame;
	}
	
	public JPanel buildMainPanel() { System.out.println("BuildGUI.buildMainPanel() executed");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		return mainPanel;
	}
	
	public JPanel buildButtonPanel() { System.out.println("BuildGUI.buildButtonPanel() executed");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		return buttonPanel;
	}
	
	public JPanel buildFieldPanel() { System.out.println("BuildGUI.buildFieldPanel() executed");
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
		
		return fieldPanel;
	}
	
	public JPanel buildLabelPanel() { System.out.println("BuildGUI.buildLabelPanel() executed");
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
		
		return labelPanel;
	}
	
	public JPanel buildPrintPanel() { System.out.println("BuildGUI.buildPrintPanel() executed");
		JPanel printPanel = new JPanel();
		
		return printPanel;
	}
	
	public JPanel horizontalButtonPanel() { System.out.println("BuildGUI.saveButtonPanel() executed");
		JPanel horizontalButtonPanel = new JPanel();
		
		return horizontalButtonPanel;
	}
	
//Menu
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem loadItem;
	private JMenuItem newItem;
	
	public JMenuBar buildMenuBar() { System.out.println("BuildGUI.buildMenuBar() executed");
		menuBar = new JMenuBar();
		
		menuBar.add(buildFileMenu());
		
		return menuBar;
	}

			
	public JMenu buildFileMenu() { System.out.println("BuildGUI.buildFileMenu() executed");
		fileMenu = new JMenu();
			
		fileMenu.setText("Fil");
		fileMenu.add(buildLoadItem());
		fileMenu.add(buildNewItem());
		
		return fileMenu;
	}
		
	public JMenuItem buildLoadItem() { System.out.println("BuildGUI.buildLoadItem() executed");
		loadItem = new JMenuItem();
			
		loadItem.setText("Ladda fil");
		loadItem.addActionListener(listeners);
		loadItem.setActionCommand("loadFile");
		
		return loadItem;
	}
	
	public JMenuItem buildNewItem() { System.out.println("BuildGUI.buildNewItem() executed");
		newItem	= new JMenuItem();
		
		newItem.setText("Nytt register");
		newItem.addActionListener(listeners);
		newItem.setActionCommand("newItem");
		
		return newItem;
	}

//UI-build
	private JFrame mainFrame;
	private JFrame question;
	private JFrame firstFrame;
	private JFrame secondFrame;
	private JFrame thirdFrame;
	private JPanel mainPanel;
	private JPanel fordonButtonPanel;
	private JPanel saveButtonPanel;
	private JPanel questionButtonPanel;
	private JPanel fieldPanel;
	private JPanel printPanel;
	private JPanel counterPanel;
	
	public void buildUI() { System.out.println("BuildGUI.buildUI() executed");
		mainFrame = buildMainFrame();
		mainPanel = buildMainPanel();
		
		fordonButtonPanel = buildButtonPanel();
		fordonButtonPanel.add(components.addButton(listeners));
		fordonButtonPanel.add(Box.createVerticalStrut(11));
		fordonButtonPanel.add(components.removeButton(listeners));
		fordonButtonPanel.add(Box.createVerticalStrut(11));
		fordonButtonPanel.add(components.searchPosButton(listeners));
		fordonButtonPanel.add(Box.createVerticalStrut(11));
		fordonButtonPanel.add(components.printButton(listeners));
		
		fieldPanel = buildFieldPanel();
		fieldPanel.add(components.typeField());
		fieldPanel.add(components.brandField());
		fieldPanel.add(components.regNrField());
		fieldPanel.add(components.ownerNameField());
		fieldPanel.add(components.ownerAgeField());
		
		counterPanel = buildLabelPanel();
		counterPanel.add(Box.createHorizontalStrut(25));
		counterPanel.add(components.maxSizeCount());
		components.printToMaxSizeCount(fordonsRegister.getMaxSize());
		counterPanel.add(components.currentSizeCount());
		components.printToCurrentSizeCount(fordonsRegister.getCurrentSize());
		
		printPanel = buildPrintPanel();
		printPanel.add(components.printField());
		
		saveButtonPanel = horizontalButtonPanel();
		saveButtonPanel.add(Box.createHorizontalStrut(55));
		saveButtonPanel.add(components.clearButton(listeners));
		saveButtonPanel.add(Box.createHorizontalStrut(25));
		saveButtonPanel.add(components.saveButton(listeners));
		saveButtonPanel.add(Box.createHorizontalStrut(25));
		saveButtonPanel.add(components.exitButton(listeners));
		
		mainPanel.add(fieldPanel);
		mainPanel.add(fordonButtonPanel);
		mainPanel.add(counterPanel);
		mainPanel.add(printPanel);
		mainPanel.add(saveButtonPanel);
		
		mainFrame.add(mainPanel);
		mainFrame.setJMenuBar(buildMenuBar());
		mainFrame.setVisible(true);
	}
	
	public JFrame getMainFrame() { System.out.println("BuildGUI.getMainFrame() executed");
		return mainFrame;
	}
	
	public void buildQuestion() { System.out.println("BuildGUI.buildQuestion() executed");
		question = secondaryFrame();
		question.setTitle("Fordonsregister");
		questionButtonPanel = horizontalButtonPanel();
		
		questionButtonPanel.add(components.newRegisterButton(listeners));
		questionButtonPanel.add(Box.createHorizontalStrut(10));
		questionButtonPanel.add(components.uploadButton(listeners));
		questionButtonPanel.add(Box.createHorizontalStrut(10));
		questionButtonPanel.add(components.playGameButton(listeners));
		
		question.add(questionButtonPanel);
		question.setDefaultCloseOperation(EXIT_ON_CLOSE);
		question.setVisible(true);
	}
	
	public JFrame getQuestion() { System.out.println("BuildGUI.getQuestion() executed");
		return question;
	}
	
	public JPanel getQuestionButtonPanel() { System.out.println("BuildGUI.getQuestionButtonPanel() executed");
		return questionButtonPanel;
	}
	
	public void buildSetRegisterSize() { System.out.println("BuildGUI.buildSetRegisterSize() executed");
		firstFrame = secondaryFrame();
		firstFrame.setTitle("Ange storlek på registret");
		mainPanel = buildMainPanel();
		
		mainPanel.add(components.sizeField());
		mainPanel.add(components.sizeButton(listeners));
		
		firstFrame.add(mainPanel);
		firstFrame.addWindowListener(listeners);
		firstFrame.setVisible(true);
	}
	
	public JFrame getFirstFrame() { System.out.println("BuildGUI.getFirstFrame() executed");
		return firstFrame;
	}
	
	public void buildSearchFunction() { System.out.println("BuildGUI.buildSearchFunction() executed");
		secondFrame = secondaryFrame();
		secondFrame.setTitle("Sök fordon enligt position");
		mainPanel = buildMainPanel();
		
		mainPanel.add(components.posField());
		mainPanel.add(components.searchActualButton(listeners));
		
		secondFrame.add(mainPanel);
		secondFrame.setVisible(true);
	}
	
	public JFrame getSecondFrame() { System.out.println("BuildGUI.getSecondFrame() executed");
		return secondFrame;
	}
	
	public void buildRemoveFordon() { System.out.println("BuildGUI.buildRemoveFordon() executed");
		thirdFrame = secondaryFrame();
		mainPanel = buildMainPanel();
		
		mainPanel.add(components.posField());
		mainPanel.add(components.removeActualButton(listeners));
		
		thirdFrame.add(mainPanel);
		thirdFrame.setVisible(true);
	}
	
	public JFrame getThirdFrame() { System.out.println("BuildGUI.getThirdFrame() executed");
		return thirdFrame;
	}
}