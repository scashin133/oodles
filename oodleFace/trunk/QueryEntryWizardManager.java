import java.awt.Component;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import org.pietschy.wizard.PanelWizardStep;
import org.pietschy.wizard.Wizard;
import org.pietschy.wizard.WizardListener;
import org.pietschy.wizard.models.StaticModel;


public class QueryEntryWizardManager extends JPanel implements ActionVisualization, ActionListener{

	Wizard myWizard;
	String queryTable;
	ArrayList<String> queryColumns = new ArrayList<String>();
	String myQuery = "COMPILEDQUERY";
	
	// PanelWizardSteps (for access by action method
	PanelWizardStep tableSelect = new PanelWizardStep();
	PanelWizardStep columnSelect = new PanelWizardStep();
	PanelWizardStep filterSelect = new PanelWizardStep();
	public QueryEntryWizardManager(){
		super();
		createWizard();
	}
	
	protected void createWizard(){
		StaticModel myModel = new StaticModel();
		
		// Select which table
		
		tableSelect.add(new JLabel("TableSelect"));
		tableSelect.setName("Select Table");
		ButtonGroup tableButtons = new ButtonGroup();
		// TODO this will eventually add a button for each table in the DB
		for (int t=0; t<6; t++){
			String tableName = "Table" + t;
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
		
		for (int c=0; c<6; c++){
			String columnName = "Column" + c;
			JCheckBox newBox = new JCheckBox(columnName);
			newBox.setActionCommand(columnName);
			newBox.setName("ColumnBox" + columnName);
			newBox.addActionListener(this);
			columnSelect.add(newBox);
		}
		
		myModel.add(columnSelect);
		
		// Filter values
		
		filterSelect.add(new JLabel("ColumnSelect"));
		filterSelect.setName("Set Filters");
		
		JButton skipButton = new JButton("Skip");
		skipButton.setName("Skip");
		skipButton.addActionListener(this);
		filterSelect.add(skipButton);
		
		myModel.add(filterSelect);
		myWizard.addWizardListener(this);
		myWizard = new Wizard(myModel);
		this.add(myWizard);
	}
	
	public void executionResult(JTable resultTable) {
		// TODO Auto-generated method stub

	}

	public JButton getExecuteButton() {
		// TODO Obviously should be a real button.
		return new JButton();
	}

	public ArrayList<String> getResult() {
		ArrayList<String> returnValue = new ArrayList<String>();
		returnValue.add(myQuery);
		return returnValue;
	}

	public boolean launch() {
		return true;
	}
	
	public void actionPerformed(ActionEvent a) {
		Component source = (Component)a.getSource();
		
		if (source.getName().startsWith("TableButton")){
			queryTable = a.getActionCommand();
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
			columnSelect.setComplete(true);
		}
		
		if (source.getName().startsWith("Skip")){
			filterSelect.setComplete(true);
		}

	}

}
