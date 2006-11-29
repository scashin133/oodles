package oodles.DBTest;



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import oodles.RMICommon.ColumnSchema;
import oodles.RMICommon.RemoteDatabase;


/**
 * This is a test-stub for the Remote Interface Remote Database. It's instantiated
 * and otherwise managed by DatabaseServerTestStub.
 * 
 * @see oodles.DBtest.DatabaseTestStub
 */
public class DatabaseTestStub extends UnicastRemoteObject implements RemoteDatabase {
	
	
	private static final long serialVersionUID = 5037932873386488970L;
	private String name;
	
	public DatabaseTestStub(String name) throws RemoteException {
		super();
		this.name = name;
	}

	public int alterTable(String tableName, ColumnSchema columnSchemaToBeAdded)
			throws SQLException {
		System.out.println("ALTER TABLE: " + tableName);
		return 0;
	}

	public int createTable(String tableName, Collection<ColumnSchema> columns)
			throws SQLException {
		System.out.println("CREATE TABLE: table '" + tableName + "'");
		return 0;
	}

	public int delete(String tableName, String whereClause) throws SQLException {
		System.out.println("DELETE: from table '" + tableName + "', where '" + whereClause + "'");
		return 0;
	}

	public int deleteAllFromTable(String tableName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ResultSet describeTable(String tableName) throws SQLException {
		System.out.println("DESCRIBE: table '" + tableName + "'");
		return null;
	}

	public int dropTable(String tableName) throws SQLException {
		System.out.println("DROP TABLE: table '" + tableName + "'");
		return 0;
	}


	public ResultSet select(String tableName, Collection<String> columns,
			String whereClause) throws SQLException {
		
		
		String columnList = "";
		
		for (String column : columns) {
			
			if (columnList.length() != 0) {
				columnList += ", ";
			}
			
			columnList += "'" + column + "'";
		}
		
		System.out.println("SELECT: table '" + tableName + "', columns (" + columnList + "), where '" + whereClause + "'");
		
		
		return null;
	}

	public ResultSet showTables() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	public int insert(String tableName, List<String> columnNames, List<String> values) throws SQLException, RemoteException {
		
		String columnList = "";
		
		for (String column : columnNames) {
			
			if (columnList.length() != 0) {
				columnList += ", ";
			}
			
			columnList += "'" + column + "'";
		}
		
		
		String valueList = "";
		
		for (String value : values) {
			
			if (valueList.length() != 0) {
				valueList += ", ";
			}
			
			valueList += "'" + value + "'";
		}
		
		System.out.println("INSERT: table '" + tableName + "', columns (" + columnList + "), values (" + valueList + ")");
		
		return 0;
	}

	public int update(String tableName, List<String> columnNames, List<String> newValues, String whereClause) throws SQLException, RemoteException {
		
		String columnList = "";
		
		for (String column : columnNames) {
			
			if (columnList.length() != 0) {
				columnList += ", ";
			}
			
			columnList += "'" + column + "'";
		}
		
		
		String valueList = "";
		
		for (String value : newValues) {
			
			if (valueList.length() != 0) {
				valueList += ", ";
			}
			
			valueList += "'" + value + "'";
		}
		
		System.out.println("UPDATE: table '" + tableName + "', columns (" + columnList + "), values (" + valueList + "), where '" + whereClause + "'");
		
		return 0;
	}

}
