/**
 * 
 */
package oodles.OodleDB;
import java.util.ArrayList;


/**
 * @author Mike Wadhera and Sam Chang
 *
 */
public class OodleTable {
	private String name;
	private OodleTableSchema schema;
	private ArrayList<OodleRow> rows;
	
	public OodleTable(){
		
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
