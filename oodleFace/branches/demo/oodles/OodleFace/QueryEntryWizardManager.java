package oodles.OodleFace;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.pietschy.wizard.PanelWizardStep;
import org.pietschy.wizard.Wizard;
import org.pietschy.wizard.WizardEvent;
import org.pietschy.wizard.WizardListener;
import org.pietschy.wizard.models.StaticModel;


public class QueryEntryWizardManager extends JPanel implements ActionVisualization, ActionListener, WizardListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4030301139710854800L;
	
	SQLExecutor mySQLE;
	
	// This is an invisible button that will be "pressed" when the wizard
	// finishes
	JButton executeButton = new JButton();
	
	Wizard myWizard;
	String queryTable;
	ArrayList<String> queryColumns = new ArrayList<String>();
	String myQuery = "SELECT ";
	
	
	// PanelWizardSteps (for access by action method
	PanelWizardStep tableSelect = new PanelWizardStep();
	PanelWizardStep columnSelect = new PanelWizardStep();
	PanelWizardStep filterSelect = new PanelWizardStep();
	
	public QueryEntryWizardManager(SQLExecutor sqle){
		super();
		mySQLE = sqle;
		executeButton.setActionCommand("execute");
		this.setLayout(new BorderLayout());
		createWizard();
	}
	
	protected void createWizard(){
		StaticModel myModel = new StaticModel();
		
		// Select which table
		tableSelect.removeAll();
		tableSelect.add(new JLabel("TableSelect"));
		tableSelect.setName("Select Table");
		ButtonGroup tableButtons = new ButtonGroup();
		// TODO this will eventually add a button for each table in the DB
		for (String tableName : OodleFaceUtil.getTables(mySQLE)){
			JRadioButton newButton = new JRadioButton(tableName);
		    newButton.setActionCommand(tableName);
		    newButton.setName("TableButton" + tableName);
		    newButton.addActionListener(this);
		    tableButtons.add(newButton);
		    tableSelect.add(newButton);
		}
		myModel.add(tableSelect);
		
		// Select Columns to display
		
		columnSelect.add(new JLabel("ColumnSelect"));
		columnSelect.setName("Select Columns");
		
		myModel.add(columnSelect);
		
		// Filter values
		filterSelect.setName("Set Filters");
		

		
		myModel.add(filterSelect);
		myWizard = new Wizard(myModel);
		myWizard.setDefaultExitMode(Wizard.EXIT_ON_FINISH);
		myWizard.addWizardListener(this);
		this.add(myWizard, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
	
	public void executionResult(JTable resultTable) {
		// Clear the wizard and and the result of the operation
		this.removeAll();
		this.add(resultTable.getTableHeader(), BorderLayout.NORTH);
		this.add(resultTable, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}

	public JButton getExecuteButton() {
		return executeButton;
	}

	public ArrayList<String> getResult() {
		ArrayList<String> returnValue = new ArrayList<String>();
		myQuery = myQuery + " FROM " + queryTable;
		ArrayList<String> conditions = new ArrayList<String>();
		
		for (Component c :filterSelect.getComponents()){
			System.out.println(c.getName());
			if (c.getName() != null && c.getName().startsWith("filter")){
				JPanel filterPane = (JPanel)c;
				JLabel columnName = (JLabel)filterPane.getComponent(0);
				JTextField operation = (JTextField)filterPane.getComponent(1);
				JTextField value = (JTextField)filterPane.getComponent(2);
				conditions.add(columnName.getText()+ " " + operation.getText() + " \"" + value.getText() + "\"");
				
			}
		}
		if (conditions.size() > 0){
			myQuery = myQuery + " WHERE ";
			for (int cond=0; cond<conditions.size(); cond++){
				myQuery = myQuery + conditions.get(cond);
				if (cond<conditions.size()-1){
					myQuery = myQuery + " AND ";
				}
			}
		}
		
		returnValue.add(myQuery);
		return returnValue;
	}

	public boolean launch() {
		this.removeAll();
		myWizard.reset();
		this.add(myWizard, BorderLayout.CENTER);
		return true;
	}
	
	public void actionPerformed(ActionEvent a) {
		Component source = (Component)a.getSource();
		
		if (source.getName().startsWith("TableButton")){
			queryTable = a.getActionCommand();
			columnSelect.removeAll();
			columnSelect.add(new JLabel("ColumnSelect"));
			for (String columnName : OodleFaceUtil.getColumns(mySQLE, queryTable)){
				JCheckBox newBox = new JCheckBox(columnName);
				newBox.setActionCommand(columnName);
				newBox.setName("ColumnBox" + columnName);
				newBox.addActionListener(this);
				columnSelect.add(newBox);
			}
			
			tableSelect.setComplete(true);
		}
		
		if (source.getName().startsWith("ColumnBox")){
			ItemSelectable checkBoxSource = (ItemSelectable)source;
			if (checkBoxSource.getSelectedObjects() != null){
				queryColumns.add(a.getActionCommand());
			}
			else {
				queryColumns.remove(a.getActionCommand());
			}
			filterSelect.removeAll();
			filterSelect.add(new JLabel("ColumnSelect"));
			for (String columnName : queryColumns){
				JPanel newFilter = new JPanel();
				newFilter.setName("filter" + columnName);
				newFilter.add(new JLabel(columnName));
				JTextField operator = new JTextField(2);
				operator.setName("operator");
				JTextField value = new JTextField(30);
				operator.setName("value");
				newFilter.add(operator);
				newFilter.add(value);
				filterSelect.add(newFilter);
			}
			columnSelect.setComplete(true);
			filterSelect.setComplete(true);
		}

	}

	public void wizardCancelled(WizardEvent arg0) {
		this.removeAll();
		createWizard();
	}

	public void wizardClosed(WizardEvent arg0) {
		// The invisible button is clicked.
		executeButton.doClick();
	}
	

}
