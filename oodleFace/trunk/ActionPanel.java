import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */

public class ActionPanel extends JPanel implements ActionListener{
	DataPanel myDataPanel = new DataPanel();
	HashMap<String,Action> actionHash = new HashMap<String,Action>();
	
	JToolBar actionPanelToolBar = new JToolBar("ActionPanelToolBar", javax.swing.SwingConstants.HORIZONTAL);
	
	public ActionPanel(){
		super();
		
		this.initialize();
	}
	
	private void initialize(){
		this.setBorder(new EtchedBorder());
		
		//Set Layout
		this.setLayout(new BorderLayout());
		
		//Add toolbar and ActionPanel to this
		this.add(actionPanelToolBar, BorderLayout.NORTH);
		this.add(myDataPanel, BorderLayout.CENTER);
		
	}
	
	public DataPanel getChild(){
		return myDataPanel;
	}
	
	public void switchView(View targetView){
		actionPanelToolBar.removeAll();
		actionHash.clear();
		for (Action a : targetView.getActions()){
			JButton newActionButton = new JButton(a.description());
			newActionButton.addActionListener(this);
			actionPanelToolBar.add(newActionButton);
			actionHash.put(a.description(), a);
		}
		this.add(actionPanelToolBar, BorderLayout.NORTH);
	}
	
	public void actionPerformed(ActionEvent e){
		JButton buttonPressed = (JButton)e.getSource();
		myDataPanel.showActionContent(actionHash.get(buttonPressed.getText()));
	}
}
