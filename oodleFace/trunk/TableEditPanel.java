import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */

//TODO This is basically just a place holder Panel for TableEditing

public class TableEditPanel extends JPanel implements ActionVisualization {
	
	JTextField queryField = new JTextField("Table Table");
	
	// The executeButton is the button that will tell the
	// DataPanel that this action has a completed User SQL 
	// request that needs to be processed.
	JButton executeButton;
	
	public TableEditPanel(){
		super();
		this.initialize();
	}
	
	private void initialize(){
		this.add(new JTextArea("Editing Table"));
		this.add(queryField);
		executeButton = new JButton("Execute");
		executeButton.setActionCommand("execute");
	}
	
	public boolean launch(){
		return true;
	}
	
	public ArrayList<String> getResult(){
		return new ArrayList<String>();
	}

	public JButton getExecuteButton() {
		return executeButton;
	}
	
}
