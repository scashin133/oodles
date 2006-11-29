package oodles.DBTest;



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import oodles.RMICommon.ColumnSchema;
import oodles.RMICommon.RemoteDatabase;


/**
 * This is a test-stub for the Remote Interface Remote Database.
 */
public class Database extends UnicastRemoteObject implements RemoteDatabase {
	
	
	
	private static final long serialVersionUID = 5037932873386488970L;
	private String name;
	
	public Database(String name) throws RemoteException {
		super();
		this.name = name;
	}

	public int alterTable(String tableName, ColumnSchema columnSchemaToBeAdded)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int createTable(String tableName, Collection<ColumnSchema> columns)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(String tableName, String whereClause) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteAllFromTable(String tableName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ResultSet describeTable(String tableName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int dropTable(String tableName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(String tableName, Collection<String> columnNames,
			Collection<String> values) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ResultSet select(String tableName, Collection<String> columns,
			String whereClause) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet showTables() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(String tableName, Collection<String> columnNames,
			Collection<String> newValues, String whereClause)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
