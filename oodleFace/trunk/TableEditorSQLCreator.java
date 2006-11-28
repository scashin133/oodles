import java.util.ArrayList;

import javax.swing.JTable;


public final class TableEditorSQLCreator {
	public static ArrayList<String> produceSQLToStoreEdit(JTable currentTable, JTable newTable){
		ArrayList<String> commandList = new ArrayList<String>();
		commandList.add("NEWTABLE");
		return commandList;
	}
}
