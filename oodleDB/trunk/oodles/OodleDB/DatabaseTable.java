/**
 * 
 */
package oodles.OodleDB;
import java.util.ArrayList;


/**
 * @author Mike Wadhera and Sam Chang
 *
 */
public class DatabaseTable extends DefaultModel {
	private String name;
	private TableSchema schema;
	
	public DatabaseTable(String name, ArrayList<String> columnNames) {
		this.name = name;
		schema = new TableSchema();
		for (String c : columnNames) {
			ColumnSchema column = new ColumnSchema(c);
			schema.addColumn(column);
		}
	}
	
	public String getName(){
		return name;
	}
	
	public void addColumn(ColumnSchema) {
		schema.addColumn(columnSchema);
	}
	
	public void deleteRow(int rowIndex){
		
	}
	
	public OodleResultSet query(ConditionList conditions){
		
	}
	
	public ArrayList<Integer> findSatisfiedRows(ConditionList conditions) {
		// step through every row in the table, returning a list of indices for the rows that satisfy the conditionlist
		ArrayList<Integer> rowIndices = new ArrayList<Integer>();
		int i = 0;
		for (Vector row : dataVector) {
			i++;
			if (rowSatisfiesConditions(row, conditions)) {
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
