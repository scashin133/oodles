import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public final class TableEditorSQLCreator {
	public static ArrayList<String> produceSQLToStoreEdit(JTable currentTable, JTable newTable){
		ArrayList<String> commandList = new ArrayList<String>();
		
		// Get the table models since this will allow us better row acces
		// both are DefaultTableModels because that's what I'll be using
		// everywhere else
		
		int columnCount = newTable.getColumnCount();
		int rowCount = newTable.getRowCount();
		for (int r=0; r<rowCount; r++){
			String newCommand = "INSERT INTO "+ newTable.getName()+ " VALUES (";
			// The first value will be added outside the loop so
			// commas can be added correctly.  We know it's a string
			// because that's all we're using for values.
			System.out.println("First value" + newTable.getValueAt(r, 0));
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
