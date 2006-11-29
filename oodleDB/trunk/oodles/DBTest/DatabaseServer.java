package oodles.DBTest;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;


import oodles.RMICommon.*;

public class DatabaseServer extends UnicastRemoteObject  implements RemoteDatabaseServer {

	/**
	 * 
	 */
	
	private String name;
	
	
	
	private static final long serialVersionUID = 5489330319053253738L;

	protected DatabaseServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int createDatabase(String databaseName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int dropDatabase(String databaseName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ResultSet showDatabases() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
     * This method will start the server, and register
     * some default DBs in the default local registry.
     * 
     * 
     * "The application never quits, it must be killed manually.
     * (The application will quit if there are no more references to the printers
     * either in the registry or on client side)." from RMI Printer Documentation
     */
    public static void main(String[] args) {
    	
    	if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
    	}
    	try {
        	
            Registry registry = LocateRegistry.getRegistry();
            
            registry.rebind("OodleDB", new DatabaseServer("OodleDB"));
            registry.rebind("OodleDB.DB1", new Database("OodleDB.DB1"));
            registry.rebind("OodleDB.DB2", new Database("OodleDB.DB2"));
            registry.rebind("OodleDB.DB3", new Database("OodleDB.DB3"));
        } catch (RemoteException e) {
            System.err.println("Something wrong happended on the remote end");
            e.printStackTrace();
            System.exit(-1); // can't just return, rmi threads may not exit
        } 
        System.out.println("The print server is ready");
    }

	public DatabaseServer(String name) throws RemoteException {
		super();
		this.name = name;
	}

}
