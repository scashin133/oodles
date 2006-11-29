/**
 * 
 */
package oodles.OodleDB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;


/**
 * @author Mike Wadhera and Sam Chang
 *
 */

public class DatabaseTable extends DefaultTableModel{
	private String name;
	private TableSchema schema;
	
	public DatabaseTable(String name, Collection<ColumnSchema> columnNames) {
		this.name = name;
		schema = new TableSchema();
		for (ColumnSchema c : columnNames) {
			schema.addColumn(c);
		}
	}
	
	public String getName(){
		return name;
	}
	
	public void addColumn(ColumnSchema column) {
		schema.addColumn(column);
	}
	
	public void deleteRow(int rowIndex){
		
	}
	
	public OodleResultSet query(ArrayList<String> columnNames, String conditions){
		return null;
	}
	
	public ArrayList<Integer> findSatisfiedRows(ConditionList conditions) {
		// step through every row in the table, returning a list of indices for the rows that satisfy the conditionlist
		ArrayList<Integer> rowIndices = new ArrayList<Integer>();
		int i = 0;
		for (Object row : getDataVector()) {
			i++;
			if (rowSatisfiesConditions((Vector)row, conditions)) {
				rowIndices.add(i);
			}
		}
		return rowIndices;
	}
	
	public boolean rowSatisfiesConditions(Vector row, ConditionList conditions) {
		// TODO step through each column in the given row, check to see if a condition exists in which it must match, if it does match for all columns return true
		return false;
	}
	
}
