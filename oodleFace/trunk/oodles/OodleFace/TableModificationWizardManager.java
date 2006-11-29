package oodles.OodleFace;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.pietschy.wizard.PanelWizardStep;
import org.pietschy.wizard.Wizard;
import org.pietschy.wizard.models.StaticModel;


public class TableModificationWizardManager extends JPanel implements
		ActionVisualization {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7346920254970000073L;
	Wizard myWizard;
	ArrayList<String> myCommands = new ArrayList<String>();
	
	public TableModificationWizardManager(){
		super();
		createWizard();
	}
	
	protected void createWizard(){
		StaticModel myModel = new StaticModel();
		
		// Choose Task
		// This will be "alter" or "create"
		PanelWizardStep chooseTask = new PanelWizardStep();
		chooseTask.add(new JLabel("ChooseTask"));
		chooseTask.setName("Choose Task");
		
		myModel.add(chooseTask);
		
		// Create a table
		PanelWizardStep createTable = new PanelWizardStep();
		createTable.add(new JLabel("CreateTable"));
		createTable.setName("Create A Table");
		
		myModel.add(createTable);
		
		// Alter Table
		PanelWizardStep alterTable = new PanelWizardStep();
		alterTable.add(new JLabel("AlterTable"));
		alterTable.setName("Choose Table and Action");
		
		myModel.add(alterTable);
		
		//Add Columns
		PanelWizardStep addColumms = new PanelWizardStep();
		addColumms.add(new JLabel("AddColumns"));
		addColumms.setName("Add Columns");
		
		myModel.add(addColumms);

		//Remove Columns
		PanelWizardStep removeColumns = new PanelWizardStep();
		removeColumns.add(new JLabel("RemoveColumns"));
		removeColumns.setName("Remove Columns");
		
		myModel.add(removeColumns);
		
		//Alter Table
		PanelWizardStep deleteTable = new PanelWizardStep();
		deleteTable.add(new JLabel("DeleteTable"));
		deleteTable.setName("Delete Table");
		
		//TODO Perhaps some sort of row searching wizard to
		// remove specific data?
		
		myModel.add(deleteTable);
		
		myWizard = new Wizard(myModel);
		this.add(myWizard);
	}
	
	
	public void executionResult(JTable resultTable) {
		// TODO Auto-generated method stub

	}

	public JButton getExecuteButton() {
		// TODO This obsviously should be a real button.
		return new JButton();
	}

	public ArrayList<String> getResult() {
		// TODO Auto-generated method stub
		return myCommands;
	}

	public boolean launch() {
		return true;
	}

}
