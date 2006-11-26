import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;


public class SQLExecutor {

	TableBuilder myTableBuilder = new TableBuilder(new TableSchemaCache());
	
	public SQLExecutor(){
		
	}
	
	public JTable executeSQL(ArrayList<String> commands) throws SQLException{
		
		JTable returnTable = new JTable(2,2);
		
		System.out.println("SQLCommands Received:");
		for (String s: commands){
			returnTable.setValueAt(s, 0, 0);
			System.out.println(s);
		}
		System.out.println();
		
		// TODO This needs to actually go execute SQL commands
		// Waiting on a stub or hopefully the JDBC component
		
		
		//ResultSet resultSet;
		//JTable returnTable = myTableBuilder.buildTable(resultSet, "NEEDTOGETNAME");

		returnTable.setBorder(new EtchedBorder());
		returnTable.setSize(100, 100);
		return returnTable;
	}
}
