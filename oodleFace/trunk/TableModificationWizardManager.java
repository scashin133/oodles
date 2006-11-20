import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.pietschy.wizard.PanelWizardStep;


public class TableModificationWizardManager extends PanelWizardStep implements
		ActionVisualization {

	public TableModificationWizardManager(){
		super();
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
		return null;
	}

	public boolean launch() {
		// TODO Auto-generated method stub
		return false;
	}

}
