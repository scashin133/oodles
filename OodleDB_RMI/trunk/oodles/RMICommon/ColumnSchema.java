package oodles.RMICommon;

/**
 * Stores the name and datatype of a column
 * 
 * @author mitch
 */
public class ColumnSchema {
	
	protected String name;
	protected String dataType;

	
	public ColumnSchema(String name, String dataType ) {
		this.name = name;
		this.dataType = dataType;
	}

	public String getName() {
		return name;
	}
	
	public String getDataType() {
		return dataType;
	}
	
}
