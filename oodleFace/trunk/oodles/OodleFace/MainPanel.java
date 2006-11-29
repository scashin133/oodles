package oodles.OodleFace;
import java.awt.BorderLayout;

import javax.swing.JPanel;

/*
 * Creator : Sam Archer
 */

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2381384270069640937L;
	// The View panel contained within the MainPanel
	ViewPanel myViewPanel= new ViewPanel();
	
	public MainPanel(){
		super();
		this.initialize();
	}
	
	private void initialize(){
		
		
		//Set up layout
		this.setLayout(new BorderLayout());
		//Add ViewPanel
		this.add(myViewPanel, BorderLayout.CENTER);
	}
	
	public ViewPanel getChild(){
		return myViewPanel;
	}
}
