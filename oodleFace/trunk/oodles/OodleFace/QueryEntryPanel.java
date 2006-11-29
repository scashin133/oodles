package oodles.OodleFace;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */

// TODO This is basically just a place holder Panel for QueryEntries


public class QueryEntryPanel extends JPanel implements ActionVisualization {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2020354813278679602L;

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
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("Enter SQL Query"));
		
		queryField.setMaximumSize(new Dimension(800, 14));
		queryField.setAlignmentX(javax.swing.JComponent.CENTER_ALIGNMENT);
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

	public void executionResult(JTable resultTable) {
		// The table will be the 4th component, if an older table
		// exists there, remove it.
		if (this.getComponentCount() == 4){
			this.remove(3);
		}
		this.add(resultTable, 3);
		
		this.revalidate();
		this.repaint();
		System.out.println("QueryEntryPanelGotTable!");
	}
	
}
