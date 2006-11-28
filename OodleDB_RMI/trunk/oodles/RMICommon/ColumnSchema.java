package oodles.RMICommon;

import java.io.Serializable;

/**
 * Stores the name and datatype of a column
 * 
 * @author mitch
 */
public class ColumnSchema implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected String name;
	protected String dataType;
		
	/**
	 * Construts a new ColumnSchema given a name and a data type
	 * 
	 * @param name The name of the column
	 * @param dataType The data type of the column
	 */
	public ColumnSchema(String name, String dataType) {
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
