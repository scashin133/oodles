package oodles.OodleFace;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//This clas builds a table given a ResultSet

public class TableBuilder {

	TableSchemaCache myTableCache;
	
	public TableBuilder(TableSchemaCache tSC){
		myTableCache = tSC;
	}
	
	public JTable buildTable(ResultSet rs, String tableName) throws SQLException{

		if (rs == null || !rs.next()) {
			return new JTable(1,1);
		}
		
		ResultSetMetaData resultMeta = rs.getMetaData();
		
		// Get Column count and names
		int colCount = resultMeta.getColumnCount();
		Vector<String> columnNames = new Vector<String>();
		for (int c=0; c < colCount; c++){
			columnNames.add(resultMeta.getColumnName(c));
		}
		
		// Create table model with 0 rows and columns from resultMeta
		DefaultTableModel returnTableModel = new DefaultTableModel(columnNames, 0);
		
		while (true){
			Vector<String> newRow = new Vector<String>();
			// For each column of this row get data and add to vector
			for (int col = 0; col < colCount; col++){
				newRow.add(rs.getString(col));
			}
			// Add vector as new row to table model
			returnTableModel.addRow(newRow);
			// If this was the last row, stop looping
			if (rs.isLast()) break;
			// Otherwise move the cursor down and continue looping
			rs.next();
		}
		
		// Create new JTable and set the table's name
		JTable returnTable = new JTable(returnTableModel);
		returnTable.setName(tableName);

		// Cache the new table
		myTableCache.cacheTable(tableName, returnTable);
		
		return returnTable;
	}
}
