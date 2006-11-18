import java.util.ArrayList;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */
/*
 * Interface inherited by the Panels that display for each Action
 */
public interface ActionVisualization {

	// TODO I'm not sure exactly what launch() is
	// supposed to accomplish.  For wizards it's useful to make the program
	// wait for the wizard to finish, however for anything else it
	// doesn't seem to serve a purpose.
	public boolean launch();
	public ArrayList<String> getResult();
}
