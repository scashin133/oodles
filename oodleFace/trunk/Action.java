import javax.swing.JPanel;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */
public class Action {
	String myDescription = "";
	ActionVisualization myPanel;
	
	public Action(String description, ActionVisualization actionPanel){
		myDescription = description;
		myPanel = actionPanel;
	}
	
	public String description(){
		return myDescription;
	}
	// TODO This SHOULD return an Object that implements ActionVisualization
	// but I had trouble with it not being recognized as a JPanel further down
	// the line
	public ActionVisualization getPanel(){
		return myPanel;
	}
}
