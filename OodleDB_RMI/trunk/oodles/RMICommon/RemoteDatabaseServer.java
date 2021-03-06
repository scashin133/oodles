package oodles.RMICommon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Provides a remote interface to the Database Server that will be made available over RMI.
 * 
 * <strong>About RemoteException</strong>
 * 
 * <p>
 * 	All the methods within this interface throw RemoteException; RemoteException is
 * 	required by RMI for dealing with RMI-level problems like lost connections,
 * 	server failure, etc.
 * </p>
 * 
 * <p>
 * 	Implementations of these interfaces need not attempt to throw RemoteExceptions,
 * 	as these exceptions are designed to originate from within the proxy object.
 * </p>
 * 
 */
public interface RemoteDatabaseServer extends Remote {
	
	
	/**
	 * <p>
	 * Maps to the SHOW DATABASES SQL statement. Returns a ResultSet containing the row and column information
	 * about a table.
	 * </p>
	 * 
	 * <strong>Columns Returned:</strong>
	 * <ul>
	 *  <li><strong>Database (String)</strong>: the name of the database</li>
	 * </ul>
	 * 
	 * @throws SQLException if a SQL error occurs.
	 * @throws RemoteException to make RMI happy
	 */
	public ResultSet showDatabases() throws SQLException, RemoteException;
	
	
	/**
	* Maps to the CREATE DATABASE SQL Statement.  The databaseName given may not be one already in use or else an exception
	* will be thrown.
	*
	* @param databaseName the name of the database you are inserting
	* @return 0 because no rows have been updated
	*  
	* @throws SQLException if a SQL error occurs.
	* @throws RemoteException to make RMI happy
	*/
	public int createDatabase(String databaseName) throws SQLException, RemoteException;

	/**
	* Maps to the DROP DATABASE SQL Statement.  Will remove all trace of database i.e. tables, schema, data, database itself.
	*
	* @param databaseName name of the database that is wanting to be deleted.  All information about database deleted.
	* @return 0 because deleting whole database or throws SQLException if error
	* 
	* @throws SQLException if a SQL error occurs.
	* @throws RemoteException to make RMI happy
	*/
	public int dropDatabase(String databaseName) throws SQLException, RemoteException;

}
