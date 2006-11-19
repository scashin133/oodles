import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */

// TODO This is basically just a place holder Panel for QueryEntries


public class QueryEntryPanel extends JPanel implements ActionVisualization {
	
	// The execute button is the button that will tell DataPanel
	// the user has finished entering data, and there's a result
	// to get from the Panel.
	JButton executeButton;
	
	JTextField queryField = new JTextField(45);
	public QueryEntryPanel(){
		super();
		this.initialize();
	}
	
	private void initialize(){
		this.add(new JLabel("Enter SQL Query"));
		this.add(queryField);
		
		
		executeButton = new JButton("Execute");
		executeButton.setActionCommand("execute");
		this.add(executeButton);
	}
	
	public boolean launch(){
		return true;
	}
	
	public JButton getExecuteButton(){
		return executeButton;
	}
	
	public ArrayList<String> getResult(){
		ArrayList<String> returnValue = new ArrayList<String>();
		returnValue.add(queryField.getText());
		return returnValue;
	}
	
}
