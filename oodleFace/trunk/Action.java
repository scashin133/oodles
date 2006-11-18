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
	
	public ActionVisualization getPanel(){
		return myPanel;
	}
}
