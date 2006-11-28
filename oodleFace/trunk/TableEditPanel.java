import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */

//TODO This is basically just a place holder Panel for TableEditing

public class TableEditPanel extends JPanel implements ActionVisualization, ActionListener {
	
	
	// This table will be created from the database.
	JTable editableTable = new JTable(2,2);
	// The executeButton is the button that will tell the
	// DataPanel that this action has a completed User SQL 
	// request that needs to be processed.
	JButton executeButton;
	
	public TableEditPanel(){
		super();
		this.initialize();
	}
	
	private void initialize(){
		JButton goButton = new JButton("go");
		goButton.setActionCommand("go");
		goButton.addActionListener(this);
		this.add(goButton);
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

	public void executionResult(JTable resultTable) {
		System.out.println("TableEditPanel Got Table!!");
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "go"){
			
		}
		
	}
	
}
