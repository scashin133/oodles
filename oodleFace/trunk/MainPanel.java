import java.awt.BorderLayout;

import javax.swing.JPanel;

/*
 * Creator : Sam Archer
 */

public class MainPanel extends JPanel {

	ViewPanel myViewPanel;
	
	public MainPanel(){
		super();
		this.initialize();
	}
	
	private void initialize(){
		myViewPanel = new ViewPanel();
		
		
		//Set up layout
		this.setLayout(new BorderLayout());
		this.add(myViewPanel, BorderLayout.CENTER);
	}
	
	public ViewPanel getChild(){
		return myViewPanel;
	}
}
