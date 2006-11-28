/**
 * 
 */
package oodles.OodleDB;

import java.util.HashMap;
import oodles.RMICommon.RemoteDatabase;

/**
 * @author Mike Wadhear and Sam Chang
 *
 */
public class OodleDatabase implements RemoteDatabase{

	private String name;
	private HashMap<String, OodleTable> tableCollection;
	
	public String getName(){
		return name;
	}
	
	public void getTables(){
		
	}
	
	public void getTables(String something){
		
	}
}
