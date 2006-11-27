package oodles.DBC;

/*
 * OodleDataSource is an object which creates Connection objects.  The OodleDataSource must be
 */
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import oodles.RMICommon.RemoteDatabaseServer;

public class OodleDataSource implements DataSource {
	
	private RemoteDatabaseServer databaseServer;

	public Connection getConnection() throws SQLException {
		
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConnection(String arg0, String arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

}
