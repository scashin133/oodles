package oodles.OodleFace;
import java.util.ArrayList;

import javax.swing.JTable;


public final class TableEditorSQLCreator {
	public static ArrayList<String> produceSQLToStoreEdit(JTable currentTable, JTable newTable){
		ArrayList<String> commandList = new ArrayList<String>();
		
		// TODO This doesn't actually check for changes, but instead
		// deletes the table and rewrites is
		
		commandList.add("DELETE * FROM " + newTable.getName());
		
		int columnCount = newTable.getColumnCount();
		int rowCount = newTable.getRowCount();
		for (int r=0; r<rowCount; r++){
			String newCommand = "INSERT INTO "+ newTable.getName()+ " VALUES (";
			// The first value will be added outside the loop so
			// commas can be added correctly.  We know it's a string
			// because that's all we're using for values.
			newCommand = newCommand + (String)newTable.getValueAt(r, 0);
			for (int c=1; c<columnCount;c++){
				newCommand = newCommand + ", "+newTable.getValueAt(r, c);
			}
			newCommand = newCommand + ")";
			commandList.add(newCommand);
		}
		return commandList;
	}
}
