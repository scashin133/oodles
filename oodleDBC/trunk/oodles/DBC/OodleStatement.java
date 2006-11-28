package oodles.DBC;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import oodles.RMICommon.ColumnSchema;

/**
 * 
 * 
 * <strong>JDBC DISCLAIMER:</strong>
 * 
 * <p>
 * The packages java.sql and javax.sql are collectively known as 
 * "JDBC"
 * </p>
 * 
 * <p>
 * JDBC's interfaces include many, many methods which provide lots of
 * wonderfully intricate functionality which have been deemed totally
 * unecessary for OodleDBC. These methods will throw SQLExceptions when
 * invoked, and have been marked as "Unsupported"
 * </p>
 * 
 * @author mitch
 *
 */
public class OodleStatement implements Statement {
	

	/** The connection object that created this OodleStatement instance */
	protected OodleConnection parentConnection;
	
	/** Caches the ResultSet from the last query we executed, or is null if the last query didn't have a ResultSet */ 
	protected ResultSet currentResultSet; 
	
	
	/** The pattern for a column schema */
	protected static final Pattern COLUMN_SCHEMA_PATTERN = 
		Pattern.compile("(\\w+)\\s+(\\w+)");
	
	
	/** The pattern for a USE query */
	protected static final Pattern USE_QUERY_PATTERN = 
		Pattern.compile("use\\s+(\\w+)");
	
	
	/** The pattern for an ALTER TABLE query */
	protected static final Pattern ALTER_QUERY_PATTERN = 
		Pattern.compile("alter\\s+table\\s+(\\w+)\\s+add\\s+column\\s+(\\w+)\\s+(\\w+)",
		Pattern.CASE_INSENSITIVE);
	
	
	/** The pattern for an CREATE query */
	protected static final Pattern CREATE_QUERY_PATTERN = 
		Pattern.compile("create\\s+(database)|(table)\\s+(.*)",
		Pattern.CASE_INSENSITIVE);
	
	
	// TODO: SELECT query patterns
	
	// TODO: DELETE query patterns
	
	// TODO: UPDATE query patterns
	
	// TODO: DESCRIBE query patterns
	
	// TODO: INSERT query patterns
	
	// TODO: SHOW query patterns
	
	// TODO: DROP query patterns
	
	/** The pattern for the table definition clause of a CREATE TABLE query */
	protected static final Pattern TABLE_DEFINITION_CLAUSE_PATTERN = 
		Pattern.compile("(\\w+)\\s+(.*)",
		Pattern.CASE_INSENSITIVE);
	
	
	/** The pattern for the table schema clause of a CREATE TABLE query */
	protected static final Pattern TABLE_SCHEMA_CLAUSE_PATTERN = 
		Pattern.compile("(\\w+\\s+\\w+)(,\\s+\\w+\\s+\\w+)*",
		Pattern.CASE_INSENSITIVE);
	
	
	
	

	
	public OodleStatement(OodleConnection connection) throws IllegalArgumentException {
		
		/* Make sure we have an actual connection */
		
		if (connection == null) {
			throw new IllegalArgumentException("Connection cannot be null.");
		}
		
		this.parentConnection = connection; 

	}
	
	
	/**
	 * Returns the ResultSet from the last query, or null if the last
	 * query didn't return a result set.
	 * 
	 * @returns ...
	 */
	public ResultSet getResultSet() throws SQLException {
		return currentResultSet;
	}
	
	
	/**
	 * Performs a query on the database.
	 */
	public boolean execute(String query) throws SQLException {
		
		/* Clear out the current result set. */
		
		currentResultSet = null;
		
		/* Peek at the query and hand it off to a helper */
		
		
		try {
		
			if ( USE_QUERY_PATTERN.matcher(query).matches() ) {
	
				executeUseQuery(query);
				
			} else if ( ALTER_QUERY_PATTERN.matcher(query).matches() ) {
				
				executeAlterQuery(query);
				
			} else if ( CREATE_QUERY_PATTERN.matcher(query).matches() ) {	
				
				executeCreateQuery(query);
				
			} else {
				
				throw new SQLException("Query was malformed.");
				
			}
		
		} catch (RemoteException e ) {
		
			/* If a RemoteException is thrown, RMI had problems and couldn't invoke the remote method */
			
			throw new SQLException("Error communicating with database server.");
			
		}
		
		return true;
		
	}
	
	
	
	
	
	/**
	 * Changes the database
	 * 
	 * @param query
	 * @throws SQLException
	 */
	protected void executeUseQuery(String query) throws SQLException, RemoteException {
		
		Matcher m = USE_QUERY_PATTERN.matcher(query);
		
		/* Make sure we match */
		
		if (m.matches() == false) {
			throw new SQLException("USE query was malformed.");
		}
		
		/* Set the parent connection to use the new database */
		
		String databaseName = m.group(1);
		
		parentConnection.useDatabase(databaseName);
		
	}
	
	/**
	 * Alter query
	 * 
	 * @param query
	 * @throws SQLException
	 */
	protected void executeAlterQuery(String query) throws SQLException, RemoteException {
		
		Matcher m = ALTER_QUERY_PATTERN.matcher(query);
		
		/* Make sure we match */
		
		if (m.matches() == false) {
			throw new SQLException("ALTER query was malformed.");
		}
		
		/* "Alter" the table */
		
		String tableName = m.group(1);
		ColumnSchema columnSchema = new ColumnSchema(m.group(2), m.group(3));
		
		parentConnection.getDatabase().alterTable(tableName, columnSchema);
		
	}
	
	
	/**
	 * <p>
	 * 	Executes a CREATE query.
	 * </p>
	 * 
	 * @param query the query.
	 * @throws SQLException if there is a problem parsing the query.
	 */
	protected void executeCreateQuery(String query) throws SQLException, RemoteException {
		
		
		Matcher m = CREATE_QUERY_PATTERN.matcher(query);
		
		/* Make sure we match */
		
		if (m.matches() == false) {
			throw new SQLException("CREATE query was malformed.");
		}
		
		
		
		if (m.group(1) != null) {
			
			/* If it's a CREATE DATABASE query */
			
			String databaseName = m.group(3);
			
			/*  make sure the database name was ok */
			
			if ( Pattern.matches("\\w+", databaseName) == false ) {
				throw new SQLException("CREATE DATABASE query was malformed.");
			}
			
			/* Create the database */
			
			parentConnection.getDatabaseServer().createDatabase(databaseName);
			
		} else {
			
			/* If it's a CREATE TABLE query */
			
			String tableDefinitionClause = m.group(3);
			
			
			/* Make sure we've got a table name and a list of column schema */
			
			Matcher tableDefinitionMatcher = TABLE_DEFINITION_CLAUSE_PATTERN.matcher(tableDefinitionClause);
			
			if ( tableDefinitionMatcher.matches() == false ) {
				throw new SQLException("CREATE TABLE query was malformed.");
			}
			
			
			/* Parse the table definition */
			
			String tableName = tableDefinitionMatcher.group(1);
			String tableSchemaClause = tableDefinitionMatcher.group(2);

			
			/* A comma delimited list of column definitions: NAME TYPE, NAME TYPE ... */
			
			if ( TABLE_SCHEMA_CLAUSE_PATTERN.matcher( tableSchemaClause ).matches() ) {
				
				/* Split into column schemas */
				
				String[] columnDefinitions = tableSchemaClause.split(",\\s+");
				
				ArrayList<ColumnSchema> columnSchemaList = new ArrayList<ColumnSchema>(columnDefinitions.length);
				

				/* Iterate over the schema and add them to the list */
				
				for (String columnSchema : columnDefinitions) {
					columnSchemaList.add(parseColumnSchema(columnSchema));
				}
				
				
				/* Create the table */
				
				parentConnection.getDatabase().createTable(tableName, columnSchemaList);
				
				
			} else {
				
				/* The table definition was malformed */
				
				throw new SQLException("CREATE TABLE query table definition was malformed.");
			}
			
		}
		
		
	}
	
	/**
	 * A helper method that constructs a ColumnSchema object from a column schema.
	 * 
	 * @param columnSchema the column schema string.
	 * 
	 * @return A new column schema object from the column schema string
	 * 
	 * @throws SQLException if there was an error 
	 */
	protected static ColumnSchema parseColumnSchema(String columnSchema) throws SQLException, RemoteException {
		
		Matcher columnSchemaMatcher = COLUMN_SCHEMA_PATTERN.matcher(columnSchema);
		
		if (columnSchemaMatcher.matches()) {
			
			String name = columnSchemaMatcher.group(1);
			String dataType = columnSchemaMatcher.group(2);
			
			return new ColumnSchema(name, dataType);
			
		} else {
			throw new SQLException("Column definition was malformed.");
		}
		
		
	}
	
	
	protected void executeDeleteQuery(String query) throws SQLException, RemoteException {
		
	}
	
	protected void executeDescribeQuery(String query) throws SQLException, RemoteException {
		
	}
	
	protected void executeDropQuery(String query) throws SQLException, RemoteException {
		
	}
	
	protected void executeInsertQuery(String query) throws SQLException, RemoteException {
		
	}
	
	protected void executeSelectQuery(String query) throws SQLException, RemoteException {
		
	}
	
	protected void executeShowQuery(String query) throws SQLException, RemoteException {
		
	}
	

	protected void executeUpdateQuery(String query) throws SQLException, RemoteException {
		
	}
	
	
	/*
	 * And now to make JDBC happy...
	 */

	public void addBatch(String arg0) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	public void cancel() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	public void clearBatch() throws SQLException {
		// TODO Auto-generated method stub

	}

	public void clearWarnings() throws SQLException {
		// TODO Auto-generated method stub

	}

	public void close() throws SQLException {
		// TODO Auto-generated method stub

	}


	public boolean execute(String arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean execute(String sql, String[] columnNames)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public int[] executeBatch() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int executeUpdate(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int executeUpdate(String sql, int autoGeneratedKeys)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int executeUpdate(String sql, int[] columnIndexes)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int executeUpdate(String sql, String[] columnNames)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getFetchDirection() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getFetchSize() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ResultSet getGeneratedKeys() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getMaxFieldSize() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getMaxRows() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean getMoreResults() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getMoreResults(int current) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public int getQueryTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getResultSetConcurrency() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getResultSetHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getResultSetType() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getUpdateCount() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCursorName(String name) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setEscapeProcessing(boolean enable) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setFetchDirection(int direction) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setFetchSize(int rows) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setMaxFieldSize(int max) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setMaxRows(int max) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setQueryTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

}
