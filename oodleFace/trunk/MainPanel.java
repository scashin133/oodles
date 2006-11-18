import java.awt.BorderLayout;

import javax.swing.JPanel;

/*
 * Creator : Sam Archer
 */

public class MainPanel extends JPanel {

	// The View panel contained within the MainPanel
	ViewPanel myViewPanel= new ViewPanel();
	
	public MainPanel(){
		super();
		this.initialize();
	}
	
	private void initialize(){
		
		// TODO The design documents have a toolbar with
		// actions for New/Load/Save.  I thought the
		// menu bar would work nicely for this but a toolbar
		// could be added later.
		
		//Set up layout
		this.setLayout(new BorderLayout());
		//Add ViewPanel
		this.add(myViewPanel, BorderLayout.CENTER);
	}
	
	public ViewPanel getChild(){
		return myViewPanel;
	}
}
