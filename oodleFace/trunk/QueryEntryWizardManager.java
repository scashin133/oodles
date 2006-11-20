import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.pietschy.wizard.PanelWizardStep;
import org.pietschy.wizard.Wizard;
import org.pietschy.wizard.models.StaticModel;


public class QueryEntryWizardManager extends JPanel implements ActionVisualization {

	Wizard myWizard;
	String myQuery = "COMPILEDQUERY";
	public QueryEntryWizardManager(){
		super();
		createWizard();
	}
	
	protected void createWizard(){
		StaticModel myModel = new StaticModel();
		
		// Select which table
		PanelWizardStep tableSelect = new PanelWizardStep();
		tableSelect.add(new JLabel("TableSelect"));
		tableSelect.setName("Select Table");
		myModel.add(tableSelect);
		
		// Select Columns to display
		PanelWizardStep columnSelect = new PanelWizardStep();
		columnSelect.add(new JLabel("ColumnSelect"));
		columnSelect.setName("Select Columns");
		
		myModel.add(columnSelect);
		
		// Filter values
		PanelWizardStep filterSelect = new PanelWizardStep();
		filterSelect.add(new JLabel("ColumnSelect"));
		filterSelect.setName("Set Filters");
		
		myModel.add(filterSelect);
		
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

}
