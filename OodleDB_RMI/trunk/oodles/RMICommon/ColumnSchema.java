package oodles.RMICommon;

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
