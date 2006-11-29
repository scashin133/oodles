package oodles.OodleFace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */


public class TableEditPanel extends JPanel implements ActionVisualization, ActionListener {
	
	SQLExecutor mySQLE;
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
	
	public TableEditPanel(SQLExecutor sqle){
		super();
		mySQLE = sqle;
		this.initialize();
	}
	
	private void initialize(){
		//TODO this needs to get the table from the database
		this.removeAll();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		editableTable.setName("table1");
		for (String tableName : OodleFaceUtil.getTables(mySQLE)){
			JButton goButton = new JButton(tableName);
			goButton.setActionCommand("table" + tableName);
			goButton.addActionListener(this);
			this.add(goButton);
		}
	}
	
	private void displayTable(JTable table){
		editableTable = table;
		JButton newRowButton = new JButton("Add Row");
		newRowButton.setActionCommand("addrow");
		newRowButton.addActionListener(this);
		JButton remRowButton = new JButton("Remove Selected Row");
		remRowButton.setActionCommand("remrow");
		remRowButton.addActionListener(this);
		executeButton.setActionCommand("execute");
		this.add(newRowButton);
		this.add(remRowButton);
		this.add(executeButton);
		this.add(new JLabel(table.getName()));
		this.add(table.getTableHeader());
		this.add(table);
		this.revalidate();
		this.repaint();
	}
	
	public boolean launch(){
		this.removeAll();
		this.initialize();
		return true;
	}
	
	public ArrayList<String> getResult(){
		return TableEditorSQLCreator.produceSQLToStoreEdit(new JTable(2,2), editableTable);
	}

	public JButton getExecuteButton() {
		return executeButton;
	}

	public void executionResult(JTable resultTable) {
		this.remove(editableTable.getTableHeader());
		this.remove(editableTable);
		editableTable = resultTable;
		this.add(editableTable.getTableHeader());
		this.add(editableTable);
		this.revalidate();
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().startsWith("table")){
			this.removeAll();
			// Whatever comes after "table" is the name of the table
			ArrayList<String> getTableCommand = new ArrayList<String>();
			getTableCommand.add("SELECT * FROM " + e.getActionCommand().substring(5));
			// Get and display this table.
			this.displayTable(mySQLE.executeSQL(getTableCommand));
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
