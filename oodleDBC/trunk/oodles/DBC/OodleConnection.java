package oodles.DBC;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.sql.Statement;

import java.util.Map;

import oodles.RMICommon.RemoteDatabase;
import oodles.RMICommon.RemoteDatabaseServer;

/**
 * <p>
 * Manages a connection (and it's session) to an OodleDB database.
 * </p>
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
 */
public class OodleConnection implements Connection {
	
	protected RemoteDatabaseServer databaseServer;
	protected RemoteDatabase database;

	/** 
	 * The RMI Registry object  --
	 * This object is a cross-RMI proxy which provides a String -> Remote map.
	 */
	protected Registry registryServer;
	
	
	/**
	 * Constructs a new OodleConnection
	 * 
	 * @param hostName The host name that this connection should connect to
	 * @param databaseName The database name that this connection should use, or null to not specify a database
	 * 
	 * @throws IllegalArgumentException
	 */
	public OodleConnection(String hostName, String databaseName) throws IllegalArgumentException {
		
		/* Attempt to connect to the RMI registry on the remote */
		
		try {
			registryServer = LocateRegistry.getRegistry(hostName);
		} catch (RemoteException e) {
			throw new IllegalArgumentException("Unable to connect to host: '" + hostName + "'");
		}
		
		
		/* Attempt to lookup the database server */
		
		try {
			databaseServer = (RemoteDatabaseServer) registryServer.lookup("OodleDB");
		} catch (NotBoundException e) {
			throw new IllegalArgumentException("'" + hostName + "' is not an OodleDB server.");
		} catch (Exception e) {
			throw new IllegalArgumentException("Connected to host '" + hostName + "', but failed to initialize connection.");
		}

		
		/* If a database was specified attempt to use it */
		
		if (databaseName != null) {
			useDatabase(databaseName);
		}
		
		
	}
	
	
	/**
	 * Creates a new statement object for interacting with the database.
	 * 
	 * @return A new statement object.
	 */
	public Statement createStatement() throws SQLException {
		// TODO: Implement : /
		return null;
	}
	

	/**
	 * Returns the database server that this connection is with.
	 * 
	 * @return The RemoteDatabaseServer object.
	 * 
	 * @see oodles.RMICommon.RemoteDatabaseServer
	 */
	public RemoteDatabaseServer getDatabaseServer() {
		return databaseServer;
	}
	
	
	/**
	 * Returns the RemoteDatabase object representing the database that's currently 
	 * in use for this session, or null if no database is currently in use.
	 * 
	 * @return the RemoteDatabase object for the database currently in use, or null if there is no
	 * currently selected database.
	 * 
	 * @see oodles.RMICommon.RemoteDatabase
	 */
	public RemoteDatabase getDatabase() {
		return database;
	}
	
	
	/**
	 * Changes the database in use for this session.
	 * 
	 * @param databaseName The name of the database to use
	 * 
	 * @throws IllegalArgumentException If there is a problem changing the database in use.
	 */
	public void useDatabase(String databaseName) throws IllegalArgumentException {
		
		try {
			database = (RemoteDatabase) registryServer.lookup("OodleDB." + databaseName);
		} catch (NotBoundException e) {
			throw new IllegalArgumentException("Couldn't find a database named '" + databaseName + "' on the server.");
		} catch (Exception e) {
			throw new IllegalArgumentException("There was an error looking up the database.");
		}
		
	}
	
	
	/*
	 * And now to make JDBC happy...
	 */
	
	/** Unsupported */
	public void close() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}
	
	/** Unsupported */
	public void clearWarnings() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public void commit() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public Statement createStatement(int arg0, int arg1) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public Statement createStatement(int arg0, int arg1, int arg2)
			throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}
	
	/** Unsupported */
	public boolean getAutoCommit() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public String getCatalog() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public int getHoldability() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public DatabaseMetaData getMetaData() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public int getTransactionIsolation() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public SQLWarning getWarnings() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public boolean isClosed() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public boolean isReadOnly() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public String nativeSQL(String sql) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public CallableStatement prepareCall(String sql) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
			throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
			throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public PreparedStatement prepareStatement(String sql, String[] columnNames)
			throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public void rollback() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public void rollback(Savepoint savepoint) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public void setCatalog(String catalog) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public void setHoldability(int holdability) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public void setReadOnly(boolean readOnly) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public Savepoint setSavepoint() throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public Savepoint setSavepoint(String name) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public void setTransactionIsolation(int level) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

	/** Unsupported */
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		throw new SQLException("Unsupported Operation.");
	}

}
