/**
 * 
 */
package oodles.OodleDB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import oodles.RMICommon.ColumnSchema;


/**
 * @author Mike Wadhera and Sam Chang
 *
 */

public class DatabaseTable extends DefaultTableModel{
	
	private String name;
	private TableSchema schema;
	
	private static final long serialVersionUID = 1L;
	
	public DatabaseTable() {
		
	}
	
	/**
	 * DatabaseTable Constructor
	 * 
	 * Builds a new DatabaseTable object based upon a name and a collection
	 * of columns
	 * @param name
	 * @param columns
	 */
	public DatabaseTable(String name, Collection<ColumnSchema> columns) {
		this.name = name;
		schema = new TableSchema();
		for (ColumnSchema c : columns) {
			schema.addColumn(c);
		}
	}
	
	/**
	 * getName()
	 * 
	 * Returns the name of the table.
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * addColumn
	 * 
	 * Adds a column to the schema.
	 * @param column
	 */
	public void addColumn(ColumnSchema column) {
		schema.addColumn(column);
	}
	
	/**
	 * deleteRow
	 * 
	 * Removes a row of information based upon the Index.
	 * @param rowIndex
	 */
	public void deleteRow(int rowIndex){
	}
	
	public OodleResultSet query(Collection<String> columnNames, String conditions){

		return null;
	}
	
	/**
	 * FindSatisfiedRows(The toned down version)
	 * 
	 * Returns only the row data that satisfies the String Conditions in the 
	 * query.
	 * 
	 * @param conditions
	 * @return
	 */
	public ArrayList<Integer> findSatisfiedRows(String conditions) {
		ConditionList cl = new ConditionList(conditions);
		return findSatisfiedRows(cl);
	}
	
	/**
	 * FindSatisfiedRows(The version on steroids)
	 * 
	 * Returns only the row data information that satisfies the conditions
	 * based up the query.  This is implemented using ConditionList which
	 * supposedly should have made things easier...
	 * 
	 * ....
	 * 
	 * ....
	 * 
	 * 
	 * @param conditions
	 * @return
	 */
	public ArrayList<Integer> findSatisfiedRows(ConditionList conditions) {
		// step through every row in the table, returning a list of indices for the rows that satisfy the conditionlist
		ArrayList<Integer> rowIndices = new ArrayList<Integer>();
		int i = 0;
		for (Object row : getDataVector()) {
			if (rowSatisfiesConditions((Vector)row, conditions)) {
				rowIndices.add(i);
			}
			i++;
		}
		return rowIndices;
	}
	
	/**
	 * rowSatisfiesConditions
	 * 
	 * This is the actual call method used by findSatisfiedRow(ConditionList weakSauce)
	 * 
	 * @param row
	 * @param conditions
	 * @return
	 */
	public boolean rowSatisfiesConditions(Vector row, ConditionList conditions) {
		// TODO step through each column in the given row, check to see if a condition exists in which it must match, if it does match for all columns return true
		return true;
	}
	
}
