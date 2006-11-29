
package oodles.OodleDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import oodles.RMICommon.RemoteDatabaseServer;
import java.util.Vector;

/**
 * File:   OodleDatabaseServer.java
 * Date:   11/28/2006
 * @author Mike Wadhera and Sam Chang
 *
 */

public class OodleDatabaseServer implements RemoteDatabaseServer {
	
	/* Setting up a list of databases
	 * and initializing a Server on/off flag
	 */
	private ArrayList<OodleDatabase> databases;
	private boolean databaseIsOn;
	
	/*
	 * Public Constructor
	 */
	public OodleDatabaseServer(){
		databaseIsOn = false;
	}
	
	/**
	 * void start()
	 * void stop()
	 * boolean dbIsRunning()
	 * 
	 * The following three methods handles/checks the
	 * on/off flag (status of the server)
	 */
			public void start(){
				databaseIsOn = true;
			}
			
			public void stop(){
				databaseIsOn = false;
			}
			
			public boolean dbIsRunning(){
				return databaseIsOn;
			}
	
	/*
	 * Implemented Functions
	 */
	
	/**
	 * showDatabases()
	 * 
	 * Outputs a list of databases.
	 */
	public OodleResultSet showDatabases() throws SQLException{
		OodleResultSet newResultSet = new OodleResultSet("DatabaseNames");
		for (int i = 0 ; i < databases.size(); i++)
		{
			Vector<String> namesOfDatabases = new Vector();
			String nameOfDB = (databases.get(i)).getName();
			namesOfDatabases.add(nameOfDB);
			newResultSet.addRow(namesOfDatabases);
		}
		return newResultSet;
	}
	
	/**
	 * dropDatabase(String databaseName)
	 * 
	 * First tries to locate the database.  If database is not found
	 * then a new database will be added to the list.  If database is found, 
	 * an SQLException message is thrown.
	 */
	
	public int createDatabase(String databaseName) throws SQLException{
		int dbExistsAt = searchFor(databaseName);
		if(dbExistsAt > -1)
		{
			throw new SQLException ("Database " + databaseName + " already exists!");
		}
		OodleDatabase newDB = new OodleDatabase(databaseName);
		databases.add(newDB);
		sortDatabase();
		return 1;
	}

	/**
	 * dropDatabase(String databaseName)
	 * 
	 * First tries to locate the database.  If database is not found
	 * SQLException is thrown with message.  If database is found, it
	 * is removed.
	 */
	
	public int dropDatabase(String databaseName) throws SQLException{
		int dbExistsAt = searchFor(databaseName);
		if(dbExistsAt == -1)
		{
			throw new SQLException ("Database " + databaseName + " does not exist!");
		}
		databases.remove(dbExistsAt);
		return 1;
	}
	
	
	/*
	 * Helper Functions 
	 */

	/**
	 * searchFor(String databaseName)
	 * 
	 * Checks for matches with the String databaeName and names of the 
	 * database in the list. Currently it implements the worse search 
	 * algorithm in the world: linear.  
	 * 
	 * Currently searchFor will return the index at where the name of
	 * database is found or it will return a value of -1 if a match is
	 * not found.
	 * 
	 * Note to self: Update to a new algorithm if time permits.
	 */
	private int searchFor(String databaseName){
		for(int i = 0; i < databases.size(); i++)
		{
			String compareValue = (databases.get(i)).getName();
			if (compareValue.compareTo(databaseName) == 0)
				return i;
		}
		return -1;
	}
	
	/**
	 * sortDatabase()
	 *
	 * It would be nice to have the list of databases alphabetically sorted.
	 * Benefits:
	 * 	1)  Improves readability when user reads a list of alphabetically
	 * 		sorted database names
	 * 	2)	Good search algorithms will require our list of database names
	 * 		sorted.
	 */
	private void sortDatabase()
	{
		//OodleDatabase needs to be Comparable
		//Collections.sort(databases, String.CASE_INSENSITIVE_ORDER);
	}
}
