package fordonsregister;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Holds listener-structure for all actions.

public class Listeners extends WindowAdapter implements ActionListener{
	
	private ButtonLogic buttonLogic;
	private BuildGUI buildGUI;
	
	public Listeners () {
		
	}
	
	public void setButtonLogic(ButtonLogic buttonLogic) {
		this.buttonLogic = buttonLogic;
	}
	
	public void setFramePanel(BuildGUI buildGUI) {
		this.buildGUI = buildGUI;
	}

//Window closing event for buildSetRegisterSize()
	@Override
	public void windowClosed(WindowEvent e) {
		buildGUI.buildQuestion();
	}
	
//Action events for all buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("newRegister")) { System.out.println("Listeners.newRegister Event executed");
			buildGUI.buildSetRegisterSize();
			buildGUI.getQuestion().setVisible(false);
		}
		
		if(e.getActionCommand().equals("upload")) { System.out.println("Listeners.upload Event executed");
			buttonLogic.loadButtonLogic();
		}
		
		if(e.getActionCommand().equals("size")) { System.out.println("Listeners.size Event executed");
			buttonLogic.sizeButtonLogic();
		}
		
		if(e.getActionCommand().equals("add")) { System.out.println("Listeners.add Event executed");
			buttonLogic.addButtonLogic();
		}
		
		if(e.getActionCommand().equals("remove")) { System.out.println("Listeners.remove Event executed");
			buildGUI.buildRemoveFordon();
		}
		
		if(e.getActionCommand().equals("print")) { System.out.println("Listeners.print Event executed");
			buttonLogic.printButtonLogic();
		}
		
		if(e.getActionCommand().equals("search")) { System.out.println("Listeners.search Event executed");
			buildGUI.buildSearchFunction();
		}
		
		if(e.getActionCommand().equals("searchActual")) { System.out.println("Listeners.searchActual Event executed");
			buttonLogic.searchButtonLogic();
		}
		
		if(e.getActionCommand().equals("removeActual")) { System.out.println("Listeners.removeActual Event executed");
			buttonLogic.removeButtonLogic();
		}
		
		if(e.getActionCommand().equals("loadFile")) { System.out.println("Listeners.loadFile Event executed");
			buttonLogic.loadButtonLogic();
		}
		
		if(e.getActionCommand().equals("saveAll")) { System.out.println("Listeners.saveAll Event executed");
			buttonLogic.saveButtonLogic();
		}
		
		if(e.getActionCommand().equals("newItem")) { System.out.println("Listeners.newItem Event executed");
			buttonLogic.newItemButtonLogic();
		}
		
		if(e.getActionCommand().equals("exit")) { System.out.println("Listeners.exit Event executed");
			buttonLogic.exitButtonLogic();
		}
		
		if(e.getActionCommand().equals("clear")) { System.out.println("Listeners.clear Event executed");
			buttonLogic.clearButtonLogic();
		}
		
		if(e.getActionCommand().equals("playGame")) { System.out.println("Listeners.playGame Event executed");
			buttonLogic.playGameButtonLogic();
		}
	}
}