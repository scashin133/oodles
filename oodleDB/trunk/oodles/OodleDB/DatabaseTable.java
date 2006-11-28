/**
 * 
 */
package oodles.OodleDB;
import java.util.ArrayList;


/**
 * @author Mike Wadhera and Sam Chang
 *
 */
public class DatabaseTable {
	private String name;
	private TableSchema schema;
	private ArrayList<OodleRow> rows;
	
	public DatabaseTable(){
		
	}
	
	public String getName(){
		return name;
	}
	
	public void addRow(OodleRow row){
		
	}
	
	public OodleRow getRow(int rowIndex){
		
	}
	
	public void deleteRow(int rowIndex){
		
	}
	
	public OodleResultSet query(ConditionList conditions){
		
	}
	
}
