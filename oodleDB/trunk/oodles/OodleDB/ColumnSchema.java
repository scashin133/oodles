/**
 * 
 */
package oodles.OodleDB;
import java.util.ArrayList;

/**
 * @author Mike Wadhera and Sam Chang
 *
 */

public class ColumnSchema {
	private String name;
	private String type;
	
	public ColumnSchema(String name)
	{
		this.name = name;
		this.type = "String";
	}
	
	public String getName(){
		return name;
	}
	
	public String getType(){
		return type;
	}
}
