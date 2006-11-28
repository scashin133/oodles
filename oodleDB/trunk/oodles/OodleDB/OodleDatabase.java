/**
 * 
 */
package oodles.OodleDB;

import java.util.HashMap;
import oodles.RMICommon.RemoteDatabase;

/**
 * @author Mike Wadhera and Sam Chang
 *
 */

public class OodleDatabase implements RemoteDatabase{

	private String name;
	private HashMap<String, DatabaseTable> tableCollection;
	
	public OodleDatabase(String name){
		name = this.name;
	}
	
	public String getName(){
		return name;
	}
	
	public void getTables(){
		
	}
	
	public void getTables(String something){
		
	}
}
