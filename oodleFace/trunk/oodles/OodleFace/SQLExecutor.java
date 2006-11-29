package oodles.OodleFace;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import oodles.DBC.OodleDataSource;



public class SQLExecutor {

	TableBuilder myTableBuilder = new TableBuilder(new TableSchemaCache());
	String dbConnectString = "oodles:72.194.123.9/DB3";
	
	public SQLExecutor(){

	}

	public JTable executeSQL(ArrayList<String> commands){

		JTable returnTable = new JTable(2,2);

		// The ResultSet is instantiated here in case there
		// is no query command.
		ResultSet resultSet = null;
		




		System.out.println("SQLCommands Received:");
		for (String s: commands){
			returnTable.setValueAt(s, 0, 0);
			System.out.println(s);
		}
		System.out.println();
		
		/// TODO WAITING FOR WORKING DBC (Uncomment when ready)
		/*

		OodleDataSource ods= new OodleDataSource("dbConnectString");

		Connection con = ods.getConnection();

		// Create a new statement
		Statement stmt = con.createStatement();

		// Execute the commands on the statement
		try {
			for (String command : commands){
				// There is only a resultSet from a 
				// select query.  This means any ArrayList
				// of commands will (in the case of oodleFace)
				// need to end with a SELECT statement so 
				// that the GUI will have a result to display
				// in the case or creation of modification
				// the query will be for the table in which 
				// the creation or modification was made.
				if (command.startsWith("SELECT")){
					resultSet = stmt.executeQuery( command );
				}

				// If it's not a SELECT statement
				// assume its an update and execute it.
				else{
					stmt.executeUpdate( command );
				}
			}
		} 
		catch (Exception e){
			System.out.println("Exception in SQL Executor, assumed to\n be fault of DBC");
		}
		finally {
			stmt.close();
		}





		//returnTable = myTableBuilder.buildTable(resultSet, OodleFaceUtil.getTableName(commands.get(0)));
		*/
		
		/// TODO DBCA Comment out this next time
		returnTable.setName(OodleFaceUtil.getTableName(commands.get(0)));
		//
		
		returnTable.setBorder(new EtchedBorder());
		returnTable.setSize(100, 100);
		return returnTable;
	}
	
	public ResultSet getResultSet(String command) throws SQLException{
		
		
		OodleDataSource ods= new OodleDataSource("dbConnectString");

		Connection con = ods.getConnection();

		// Create a new statement
		Statement stmt = con.createStatement();
		
		return stmt.executeQuery( command );
		
		
	}
}
