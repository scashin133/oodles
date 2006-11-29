package oodles.OodleFace;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */
/*
 * Interface inherited by the Panels that display for each Action
 */
public interface ActionVisualization {

	// This function was left in only because it was specified in the design
	// At this point it does not serve a purpose.
	public boolean launch();
	public ArrayList<String> getResult();
	
	// This method was added so that DataPanel knows
	// which button to listen for.
	public JButton getExecuteButton();
	
	// This method was added so DataPanel doesn't need to 
	// determine the correct method to send data back to
	// (more options for adding actions in the future.
	public void executionResult(JTable resultTable);
}
