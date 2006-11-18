import java.util.ArrayList;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */

public class View {
	String myName;
	String myIcon;
	
	ArrayList<Action> myActions = new ArrayList<Action>();
	
	public View(String viewName){
		myName = viewName;
	}
	
	public void addAction(Action newAction){
		myActions.add(newAction);
	}
	
	public String name(){
		return myName;
	}
	
	public String icon(){
		return myIcon;
	}
	
	public ArrayList<Action> getActions(){
		return myActions;
	}
}
