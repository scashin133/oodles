package oodles.OodleFace;
import java.util.HashMap;

import javax.swing.JTable;


public class TableSchemaCache {

	HashMap<String, JTable> tableCache = new HashMap<String, JTable>();
	
	public TableSchemaCache(){
		
	}

	public JTable getTable(String tableName){
		return tableCache.get(tableName);
	}
	
	
	// This method checks the cache for an exisiting table
	// if it exists, it is replaces with this new table
	// if not, this new one is added.
	public void cacheTable(String tableName, JTable table){
		if (tableCache.containsKey(tableName)){
			tableCache.remove(tableName);
		}
		tableCache.put(tableName, table);
	}
	
	public void removeTable(String tableName){
		tableCache.remove(tableName);
	}
	
	// These both have been replaced by "cacheTable"
	/*
	public void addTable(String tableName, JTable table){
		tableCache.put(tableName, table);
	}
	public void changeTableSchema(String tableName, JTable table){
		tableCache.remove(tableName);
		addTable(tableName, table);
	}
	*/
}
