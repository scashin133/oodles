package oodles.OodleFace;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

//This was created initially to house the getTableName command
//because there are several instances when a table name is needed
//but only an SQL command is available.

public class OodleFaceUtil {

	// This will take a command and return the table that is being
	// addressed
	public static String getTableName(String command){
		Scanner s = new Scanner(command);
		// Look for a statement that preceeds a table name
		while (s.hasNext() && !s.hasNext(Pattern.compile("FROM|TABLE|INTO|ON"))){
			s.next();
		}
		// If the loop exits, there's either table name or
		// its reached the end of the String
		if (s.hasNext()){
			// burn the preceeding token
			// and take the next as the table name
			s.next();
			String tableName = s.next();
			System.out.println("Table Name: " + tableName);
			return tableName;
		}

		// Otherwise, there was no token found, and an error message
		// needs to be displayed.  Return null.
		else {
			return null;
		}
	}

	public static ArrayList<String> getTables(SQLExecutor sqle){
		ArrayList<String> tableNames = new ArrayList<String>();
		/*
		try {
			ResultSet rs = sqle.getResultSet("SHOW TABLES");
			rs.first();
			while (!rs.isAfterLast()){
				tableNames.add(rs.getString(0));
				rs.next();
			}
		}
		catch (SQLException s){
			s.printStackTrace();
		}
		 */
		//TODO REMOVE THIS WHEN THE DBC WORKS
		tableNames.clear();
		tableNames.add("Table1");
		tableNames.add("Table2");
		tableNames.add("Table3");
		tableNames.add("Some Other Table");

		return tableNames;
	}

	public static ArrayList<String> getColumns(SQLExecutor sqle, String tableName){
		ArrayList<String> columnNames = new ArrayList<String>();
		/*
		try {
			ResultSet rs = sqle.getResultSet("SHOW COLUMNS FROM " + tableName);
			rs.first();
			while (!rs.isAfterLast()){
				columnNames.add(rs.getString(0));
				rs.next();
			}
		}
		catch (SQLException s){
			s.printStackTrace();
		}
		*/
		//TODO REMOVE THIS WHEN THE DBC WORKS
		columnNames.clear();
		columnNames.add("Column1");
		columnNames.add("Column2");
		columnNames.add("Column3");
		columnNames.add("Some Other Column");

		return columnNames;
	}
}
