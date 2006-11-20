package oodles.RMICommon;

import java.rmi.Remote;

public interface ColumnSchema extends Remote {

	public String getColumnName();
	
	public String getColumnDataType();
	
}
