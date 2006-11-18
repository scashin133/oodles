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
	
	//The DataPanel contained in this action panel
	DataPanel myDataPanel = new DataPanel();
	
	//Hash of all the actions available on this panel
	//Hashed so they can be looked up by their name thrown with
	//swing events.
	HashMap<String,Action> actionHash = new HashMap<String,Action>();
	
	//The ToolBal that will house the clickable things representing actions
	JToolBar actionPanelToolBar = new JToolBar("ActionPanelToolBar", javax.swing.SwingConstants.HORIZONTAL);
	
	public ActionPanel(){
		super();
		this.initialize();
	}
	
	private void initialize(){
		
		//Set Border
		this.setBorder(new EtchedBorder());
		
		//Set Layout
		this.setLayout(new BorderLayout());
		
		//Add toolbar and DataPanel to this
		this.add(actionPanelToolBar, BorderLayout.NORTH);
		this.add(myDataPanel, BorderLayout.CENTER);
		
	}
	
	public DataPanel getChild(){
		return myDataPanel;
	}
	
	//Called from actionPerformed in the ViewPanel class.
	//Changes available actions on toolbar to represent those
	//present in target view.
	public void switchView(View targetView){
		// Remove old components from the toolbar
		actionPanelToolBar.removeAll();
		// Clear the available actions
		actionHash.clear();
		
		// For each action...
		for (Action a : targetView.getActions()){
			//Make a new JButton with the action description as text
			// TODO Should probably use text instead of buttons
			JButton newActionButton = new JButton(a.description());
			//Register the button with the ActionPanel
			newActionButton.addActionListener(this);
			//Add the button to the toolbar
			actionPanelToolBar.add(newActionButton);
			//Add the action to the hash
			actionHash.put(a.description(), a);
		}
		//After the toolbar has been populated, add it to the ActionPanel
		this.add(actionPanelToolBar, BorderLayout.NORTH);
	}
	//This is triggered by an action button being pressed.
	public void actionPerformed(ActionEvent e){
		//Cast Object of source to JButton
		// TODO This might be a dangerous cast, but I don't have a way around
		// it that I know of
		JButton buttonPressed = (JButton)e.getSource();
		//Tell the data panel to show the content of the action that
		//has been selected.
		myDataPanel.showActionContent(actionHash.get(buttonPressed.getText()));
	}
}
