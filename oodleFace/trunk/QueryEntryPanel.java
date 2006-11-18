import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */

public class QueryEntryPanel extends JPanel implements ActionVisualization {
	
	JTextField queryField = new JTextField("Enter Querey Here");
	public QueryEntryPanel(){
		super();
		this.initialize();
	}
	
	private void initialize(){
		this.add(new JTextArea("Enter SQL Query"));
		this.add(queryField);
	}
	
	public boolean launch(){
		return true;
	}
	
	public ArrayList<String> getResult(){
		ArrayList<String> returnValue = new ArrayList<String>();
		returnValue.add(queryField.getText());
		return returnValue;
	}
	
}
