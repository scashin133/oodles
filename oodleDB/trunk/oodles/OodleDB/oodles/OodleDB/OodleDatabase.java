/**
 * 
 */
package oodles.OodleDB;


import oodles.RMICommon.*;
import java.util.HashMap;

/**
 * @author Mike Wadhera and Sam Chang
 *
 */
public class OodleDatabase implements RemoteDatabase{
	private String name;
	private HashMap<String, OodleTable> tableCollection;
	
	public String getName(){
		return name;
	}
}
