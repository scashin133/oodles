package oodles.OodleDB;

import java.util.ArrayList;

/**
 * @author Mike Wadhera and Sam Chang
 *
 */
public class TableSchema {
	
	private ColumnSchema primaryKey;
	private ArrayList<ColumnSchema> schema;
	
	public TableSchema() {
		schema = new ArrayList<ColumnSchema>();
	}
	
	public ColumnSchema getPrimaryKey(){
		return primaryKey;
	}
	
	public void addColumn(ColumnSchema column){
		schema.add(column);
	}
	
	public ColumnSchema getColumn(String name){
		for(int i = 0; i < schema.size(); i++)
		{
			ColumnSchema tempColumn = schema.get(i);
			String columnName = tempColumn.getName();
			if(columnName.equals(name)) { return tempColumn; }
		}
		return null;
	}
	
	public int deleteColumn(String name){
		int columnAt = getColumnIndex(name);
		if(columnAt >= 0) 
		{
			schema.remove(columnAt);
			return 1;
		}
		return 0;
	}
	
	public int getColumnIndex(String name){
		for(int i = 0; i < schema.size(); i++)
		{
			ColumnSchema tempColumn = schema.get(i);
			String columnName = tempColumn.getName();
			if(columnName.equals(name)) { return i; }
		}
		return -1;
	}
	
}
