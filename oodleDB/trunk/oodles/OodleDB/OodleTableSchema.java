package oodles.OodleDB;

import java.util.HashMap;

/**
 * @author Mike Wadhear and Sam Chang
 *
 */
public class OodleTableSchema {
	private OodleColumn primaryKey;
	private HashMap<String, OodleColumn> columns;
	
	public OodleTableSchema(){
		
	}
	
	//Mike, I might've interpreted this incorrectly.
	public OodleColumn getPrimaryKey(){
		return primaryKey;
	}
	
	public void addColumn(OodleColumn column){
		
	}
	
	public OodleColumn getColumn(String name){
		return null;
	}
	
}
