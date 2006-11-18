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
		
		this.initialize();
	}
	
	private void initialize(){
		//Set Border
		this.setBorder(new EtchedBorder());
		//Set Layout
		this.setLayout(new BorderLayout());
	}
	
	//This is called by the ActionPanel when an action is selected.
	public void showActionContent(Action targetAction){
		//Remove any components in the DataPanel
		this.removeAll();
		//Add the Panel associated with the action
		this.add(targetAction.getPanel(), BorderLayout.CENTER);
		// TODO For whatever reason this needs to be revailidated AND
		// repainted every time it's changed in order to immediately
		// reflect action choices.  If anyone knows a way around this
		// feel free to change it.
		this.revalidate();
		this.repaint();
	}

}
