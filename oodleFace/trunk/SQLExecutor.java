import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import oodles.DBC.OodleConnection;
import oodles.DBC.OodleResultSet;


public class SQLExecutor {

	TableBuilder myTableBuilder = new TableBuilder(new TableSchemaCache());

	public SQLExecutor(){

	}

	public JTable executeSQL(ArrayList<String> commands) throws SQLException{

		JTable returnTable = new JTable(2,2);
		
		// The ResultSet is instantiated here in case there
		// is no query command.
		ResultSet resultSet = new OodleResultSet();

		System.out.println("SQLCommands Received:");
		for (String s: commands){
			returnTable.setValueAt(s, 0, 0);
			System.out.println(s);
		}
		System.out.println();

		// TODO this might need to come from a 
		// Class.forName( "com.somejdbcvendor.TheirJdbcDriver" );
		// -like statement, but I'm not sure.
		Connection con = new OodleConnection();

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
		} finally {
			stmt.close();
		}


		// TODO This needs to actually go execute SQL commands
		// Waiting on a stub or hopefully the JDBC component


		//ResultSet resultSet;
		
		//JTable returnTable = myTableBuilder.buildTable(resultSet, "NEEDTOGETNAME");

		returnTable.setBorder(new EtchedBorder());
		returnTable.setSize(100, 100);
		return returnTable;
	}
}
