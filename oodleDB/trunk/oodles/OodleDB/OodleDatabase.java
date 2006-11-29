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
	
	public OodleResultSet select(String tableName, Collection<String> columnNames, String conditions) {
		DatabaseTable table = tableCollection.get(tableName);
		return table.query(columnNames, conditions);
	}
	
	public int createTable(String tableName, Collection<ColumnSchema> columns, ConditionList conditions) {
		DatabaseTable table = new DatabaseTable(tableName, columns);
		tableCollection.put(tableName, table);
		return tableCollection.size();
	}
	
	public int alterTable(String tableName, ColumnSchema newColumn) {
		DatabaseTable table = tableCollection.get(tableName);
		if (table != null) {
			table.addColumn(newColumn);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int update(String tableName, Collection<String> columnNames, Collection<String> newValues, ConditionList conditions) {
		return 0;
	}

	public int alterTable(String tableName, oodles.RMICommon.ColumnSchema columnSchemaToBeAdded) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(String tableName, String whereClause) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteAllFromTable(String tableName) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ResultSet describeTable(String tableName) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int dropTable(String tableName) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(String tableName, Collection<String> columnNames, Collection<String> values) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ResultSet showTables() throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(String tableName, Collection<String> columnNames, Collection<String> newValues, String whereClause) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
