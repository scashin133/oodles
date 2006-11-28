package oodles.RMICommon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Provides a remote interface to the Database Server that will be made available over RMI.
 */
public interface RemoteDatabaseServer extends Remote {
	
	
	/**
	 * Maps to the SHOW DATABASES SQL statement. Returns a ResultSet containing the row and column information
	 * about a table.
	 * 
	 * Columnns Returned:
	 * - Database: the name of the database
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
