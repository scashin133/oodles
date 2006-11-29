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
		tableCollection = new HashMap<String, DatabaseTable>();
	}
	
	public String getName(){
		return name;
	}
	
	public void getTables(){
		
	}
	
	public void getTables(String something){
		
	}
	
	public OodleResultSet select(String tableName, ArrayList<String> columnNames, ConditionList conditions) {
		DatabaseTable table = tableCollection.get(tableName);
		return table.query(columnNames, conditions);
	}
	
	public int createTable(String tableName, ArrayList<String> columnNames, ConditionList conditions) {
		DatabaseTable table = new DatabaseTable(tableName, columnNames);
		tableCollection.add(tableName, table);
		return tableCollection.size;
	}
	
	public int alterTable(String tableName, ColumnSchema newColumn) {
		table = tableCollection.get(tableName);
		if (table != null) {
			table.addColumn(newColumn);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int update(String tableName, Collection<String> columnNames, Collection<String> newValues, ConditionList conditions) {
		
	}
}
