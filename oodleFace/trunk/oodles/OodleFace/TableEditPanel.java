package oodles.OodleFace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */


public class TableEditPanel extends JPanel implements ActionVisualization, ActionListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1968431312354953204L;
	// This table will be created from the database.
	JTable editableTable = new JTable(2,2);
	// The executeButton is the button that will tell the
	// DataPanel that this action has a completed User SQL 
	// request that needs to be processed.
	JButton executeButton = new JButton("Commit Changes");
	
	public TableEditPanel(){
		super();
		this.initialize();
	}
	
	private void initialize(){
		//TODO this needs to get the table from the database
		
		editableTable.setName("table1");
		JButton goButton = new JButton("go");
		goButton.setActionCommand("go");
		goButton.addActionListener(this);
		this.add(goButton);
	}
	
	private void displayTable(JTable table){
		this.add(table);
		executeButton.setActionCommand("execute");
		this.add(executeButton);
		JButton newRowButton = new JButton("Add Row");
		newRowButton.setActionCommand("addrow");
		newRowButton.addActionListener(this);
		JButton remRowButton = new JButton("Remove Selected Row");
		remRowButton.setActionCommand("remrow");
		remRowButton.addActionListener(this);
		this.add(newRowButton);
		this.add(remRowButton);
		this.revalidate();
		this.repaint();
	}
	
	public boolean launch(){
		return true;
	}
	
	public ArrayList<String> getResult(){
		return TableEditorSQLCreator.produceSQLToStoreEdit(new JTable(2,2), editableTable);
	}

	public JButton getExecuteButton() {
		return executeButton;
	}

	public void executionResult(JTable resultTable) {
		System.out.println("TableEditPanel Got Table!!");
		editableTable = resultTable;
		this.revalidate();
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "go"){
			this.removeAll();
			this.displayTable(editableTable);
		}
		if (e.getActionCommand() == "addrow"){
			DefaultTableModel tableModel = (DefaultTableModel)editableTable.getModel();
			tableModel.addRow(new Vector());
			this.revalidate();
			this.repaint();
		}
		if (e.getActionCommand() == "remrow"){
			int rowToRemove = editableTable.getSelectedRow();
			// If no row is selected, remove the last row.
			if (rowToRemove == -1){
				rowToRemove = editableTable.getRowCount()-1;
			}
			DefaultTableModel tableModel = (DefaultTableModel)editableTable.getModel();
			tableModel.removeRow(rowToRemove);
			this.revalidate();
			this.repaint();
		}
		
	}
	
}
