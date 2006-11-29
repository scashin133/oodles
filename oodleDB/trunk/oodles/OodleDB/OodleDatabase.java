/**
 * 
 */
package oodles.OodleDB;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import oodles.RMICommon.ColumnSchema;
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
	
	/**
	 * Query Functions
	 */
	
	public OodleResultSet select(String tableName, Collection<String> columnNames, String conditions) {
		DatabaseTable table = tableCollection.get(tableName);
		return table.query(columnNames, conditions);
	}

	
	public int createTable(String tableName, Collection<ColumnSchema> columns) throws SQLException, RemoteException {
		DatabaseTable table = new DatabaseTable(tableName, columns);  // <--Confused, Why an error?
		tableCollection.put(tableName, table);
		return tableCollection.size();
	}

	public int alterTable(String tableName, ColumnSchema newColumn) throws SQLException, RemoteException {
		DatabaseTable table = tableCollection.get(tableName);
		if (table != null) {
			table.addColumn(newColumn);
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * update query
	 * 
	 * A bit messy only because did not implement or handle index saving in the ResultSet.  
	 * Therefore this update has to manage checking for specific index matches.
	 * 
	 * Not a great way to implement but saves time for now.	
	 */
	public int update(String tableName, Collection<String> columnNames, List<String> newValues, String conditions) throws SQLException, RemoteException {
		DatabaseTable table = tableCollection.get(tableName);
		int affectedRows = 0;
		if (table != null) {
			ArrayList<Integer> indices = table.findSatisfiedRows(conditions);
			for (int index : indices) {
				// Step through each column in the row and check to see if we need to update each column's value
				for (int i=0;i<table.getColumnCount();i++) {
					// Step through each column specificed in the update to see if its the one we are on
					int columnIndex = 0;
					for (String column : columnNames) {
						if (table.getColumnName(i) == column) {
							// Rewrite the columns data
							table.setValueAt(newValues.get(columnIndex), index, i);
							affectedRows++;
						}
						columnIndex++;
					}
				}
			}
			return affectedRows;
		} else {
			return affectedRows;
		}
	}

	public int delete(String tableName, String whereClause) throws SQLException, RemoteException {
		DatabaseTable table = tableCollection.get(tableName);
		int affectedRows = 0;
		if (table != null) {
			ArrayList<Integer> indices = table.findSatisfiedRows(whereClause);
			for (int index : indices) {
				table.removeRow(index);
				affectedRows++;
			}
		}
		return affectedRows;
	}

	public int deleteAllFromTable(String tableName) throws SQLException, RemoteException {
		DatabaseTable table = tableCollection.get(tableName);
		int total = table.getRowCount();
		for (int i=0;i<total;i++) {
			table.removeRow(i);
		}
		return total;
	}

	public ResultSet describeTable(String tableName) throws SQLException, RemoteException {
		return null;
	}

	public int dropTable(String tableName) throws SQLException, RemoteException {
		if (tableCollection.get(tableName) != null) {
			tableCollection.remove(tableName);
			return 1;
		} else {
			return 0;
		}
	}
	
	
	public int insert(String tableName, Collection<String> columnNames, List<String> values) throws SQLException, RemoteException {
		DatabaseTable table = tableCollection.get(tableName);
		if (table != null) {
			Vector rowData = null;
			table.addRow(rowData);
			int index = table.getRowCount() - 1;
				// Step through each column in the row and check to see if we need to update each column's value
				for (int i=0;i<table.getColumnCount();i++) {
					// Step through each column specificed in the insert to see if its the one we are on
					int columnIndex = 0;
					for (String column : columnNames) {
						if (table.getColumnName(i) == column) {
							// Rewrite the columns data
							table.setValueAt(values.get(columnIndex), index, i);
						}
						columnIndex++;
					}
				}			
			return 1;
		} else {
			return 0;
		}
	}

	public ResultSet showTables() throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
