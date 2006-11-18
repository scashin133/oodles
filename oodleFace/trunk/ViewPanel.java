import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */

public class ViewPanel extends JPanel implements ActionListener{
	
	// myActionPanel is declared here so it can be accessed from getChild()
	ActionPanel myActionPanel = new ActionPanel();
	
	HashMap<String, View> viewHash = new HashMap<String, View>();
	
	JToolBar viewPanelToolBar = new JToolBar("ViewPanelToolBar", javax.swing.SwingConstants.VERTICAL);
	
	public ViewPanel(){
		super();
		
		this.initialize();
	}
	
	private void initialize(){
		this.setBorder(new EtchedBorder());
		
		//Create and add panel title label
		JLabel viewPanelTitle = new JLabel("ViewPanel");
		viewPanelToolBar.add(viewPanelTitle);
		
		//Set Layout
		this.setLayout(new BorderLayout());
		
		//Add toolbar and ActionPanel to this
		this.add(viewPanelToolBar, BorderLayout.WEST);
		this.add(myActionPanel, BorderLayout.CENTER);
	}
	
	public ActionPanel getChild(){
		return myActionPanel;
	}
	
	public void addView(View newView){
		viewHash.put(newView.name(), newView);
		JButton newViewButton = new JButton(newView.name());
		newViewButton.addActionListener(this);
		viewPanelToolBar.add(newViewButton);
	}
	
	public void actionPerformed(ActionEvent e){
		JButton buttonPressed = (JButton)e.getSource();
		myActionPanel.switchView(viewHash.get(buttonPressed.getText()));
	}
}
