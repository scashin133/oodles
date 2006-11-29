package oodles.OodleFace;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */

public class View {
	String myName;
	ImageIcon myIcon;
	
	// Actions are stored here as an ArrayList because they never
	// need to be looked up specifically.
	ArrayList<Action> myActions = new ArrayList<Action>();
	
	public View(String viewName, ImageIcon viewIcon){
		myName = viewName;
		myIcon = viewIcon;
	}
	
	public void addAction(Action newAction){
		myActions.add(newAction);
	}
	
	public String name(){
		return myName;
	}
	
	public ImageIcon icon(){
		return myIcon;
	}
	
	public ArrayList<Action> getActions(){
		return myActions;
	}
}
