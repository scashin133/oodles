package clientTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import oodles.DBC.OodleDataSource;

public class OodleClientTest {
	
	public static void main(String[] args) {
		
		DataSource dbSource = new OodleDataSource("oodles:localhost/DB3");
		
		Connection dbConnection = null;
		try {
			dbConnection = dbSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		
		Statement myStatement = null;
		try {
			
			myStatement = dbConnection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			myStatement.execute("use DB2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
