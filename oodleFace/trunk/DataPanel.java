import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */

public class DataPanel extends JPanel {
	
	public DataPanel(){
		super();
		
		this.setBorder(new EtchedBorder());
		
		this.setLayout(new BorderLayout());
	}
	
	public void showActionContent(Action targetAction){
		this.add((JPanel)targetAction.getPanel(), BorderLayout.CENTER);
	}

}
