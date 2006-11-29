package oodles.OodleDB;

import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Ref;
import java.sql.ResultSetMetaData;
import javax.sql.rowset.RowSetMetaDataImpl;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 * This class serves as a starting point for implementing a ResultSet.
 * 
 * This class must be serializable because it is going to be passed across the RMI
 * layer
 * 
 * @author mitch
 * edited 11/28/06 by Sam Chang
 *
 */

public class OodleResultSet
	extends DefaultTableModel
	implements java.sql.ResultSet, ResultSetMetaData, Serializable{
	
	public ResultSetMetaData getMetaData() throws SQLException {
		// We don't really need this so lets just satisfy the interface w/a null cookie
		return null;
	}

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private static String SQL_NULL = null;
	int cursor = 0;
	String tableName;
	
	public OodleResultSet(String tableName){
		this.tableName = tableName;
	}
	
	
	
	/**
	 * boolean first() throws SQLException
	 * 
	 * Moves the cursor to the first row in this ResultSet object. 
	 * Returns: true if the cursor is on a valid row; false if there are no rows in the result set 
	 */
	
	public boolean first() throws SQLException {
		if(getRowCount() == 0) { return false; }
		cursor = 0;
		return true;
	}

	/**
	 * ResultSetMetaData getMetaData() throws SQLException
	 * Retrieves the number, types and properties of this ResultSet object's columns. 
	 * Returns: the description of this ResultSet object's columns 
	 * 
	 * Need to look in to ResultSetMetaData and RowSetMetaData
	 */

	/*
	 public ResultSetMetaData getMetaData() throws SQLException {
		ResultSetMetaData metaData = new RowSetMetaDataImpl();
		return metaData;
	}*/

	/**
	 * String getString(int columnIndex)throws SQLException
	 * 
	 * Retrieves the value of the designated column in the current row of this ResultSet 
	 * object as a String in the Java programming language. 
	 * 
	 * Parameters:	columnIndex - the first column is 1, the second is 2, ...
	 * Returns: 	the column value; if the value is SQL NULL, the value returned is null 
	 * 
	 */
	public String getString(int arg0) throws SQLException {
		if(arg0 > 0 && arg0 <= getColumnCount())
		{
			String value = (String) getValueAt(cursor, arg0);
			if(value == SQL_NULL) return null;
			return value;
		}
		else throw new SQLException("arg0 in getString is out of bounds.");
	}

	/**
	 * String getString(String columnName)throws SQLException
	 * 
	 * Retrieves the value of the designated column in the current row of this ResultSet 
	 * object as a String in the Java programming language.
	 *  
	 * Parameters:	columnName - the SQL name of the column 
	 * Returns:		the column value; if the value is SQL NULL, the value returned is null 
	 * 
	 * Edit:  getString(String arg0) now uses a search function to retrieve an index
	 * and uses that index to get the value by calling getString(int arg0).
	 * 
	 */
	public String getString(String arg0) throws SQLException {
		int indexOfColumn = findIndexOfColumnName(arg0);
		return (String) getValueAt(cursor, indexOfColumn);
	}
	
	/**
	 * int findIndexOfColumnName(String columnName) throws SQLException
	 * 
	 * Retrieves the index value at where the designated column is located
	 * in the DefaultTableModel data vector.
	 * 
	 * @param 	columnName
	 * @returns	the index where columnName is found.
	 * @throws 	SQLException
	 */
	public int findIndexOfColumnName(String columnName) throws SQLException{
		for (int i = 1; i <= getColumnCount(); i++)
		{
			String compareStringTo = getColumnName(i);
			if(compareStringTo.compareTo(columnName) == 0)
				return i;
		}
		throw new SQLException("No such column name: " + columnName + ".");
	}
	
	/**
	 * String getColumnName(int arg0) throws SQLException 
	 * 
	 * Retrieves the name of the column at index arg0.  
	 */
	public String getColumnName(int arg0) {
		String nameOfColumn = "";
		if(arg0 > 0 && arg0 <= getColumnCount())
		{
			nameOfColumn = getColumnName(arg0);
		}
		return nameOfColumn;
	}
	
	/**
	 * getColumnType(int arg0) throws SQLException 
	 * 
	 * Since we are always using Strings, we will return the value of
	 * VARCHAR
	 */
	public int getColumnType(int arg0) throws SQLException {
		return java.sql.Types.VARCHAR;
	}

	/**
	 * getColumnTypeName(int arg0) throws SQLException
	 * 
	 * Since we are always using Strings, we will return VARCHAR here.
	 */
	public String getColumnTypeName(int arg0) throws SQLException {
		return "VARCHAR";
	}

	/**
	 * String getTableName(int arg0) throws SQLException 
	 * 
	 * Retrieves the name of the table.  Since we are dealing with single table
	 * ResultSets we only need to return and hold one table name.
	 */
	public String getTableName(int arg0) throws SQLException {
		return tableName;
	}

	/**
	 * boolean isAfterLast() throws SQLException 
	 * 
	 * Retrieves whether the cursor is after the last row in this ResultSet object.
	 */
	public boolean isAfterLast() throws SQLException {
		if (cursor > getRowCount())	{ return true;  }
		return false;	
	}

	/**
	 * boolean isBeforeFirst() throws SQLException 
	 * 
	 * Retrieves whether the cursor is before the first row in this ResultSet object.
	 */
	public boolean isBeforeFirst() throws SQLException {
		if (cursor == 0) {return true;}
		return false;
	}

	/**
	 * boolean isFirst() throws SQLException 
	 * 
	 * Retrieves whether the cursor is on the first row of this ResultSet object.
	 */
	public boolean isFirst() throws SQLException {
		if (cursor == 1) {return true;}
		return false;
	}

	/**
	 * boolean isLast() throws SQLException
	 * 
	 * Retrieves whether the cursor is on the last row of this ResultSet object.
	 */
	public boolean isLast() throws SQLException {
		if (cursor == getRowCount()) {return true;}
		return false;
	}

	/**
	 * boolean last() throws SQLException 
	 * 
	 * Moves the cursor to the last row in this ResultSet object.
	 */
	public boolean last() throws SQLException {
		if (getRowCount() == 0) {return false;}
		cursor = getRowCount();
		return true;
	}

	/**
	 * boolean next() throws SQLException
	 * 
	 * Retrieves whether the cursor is on the last row of this ResultSet object.
	 */
	public boolean next() throws SQLException {
		cursor++;	
	}

	/**
	 * public boolean previous() throws SQLException 
	 * 
	 * Moves the cursor to the previous row in this ResultSet object.
	 */
	public boolean previous() throws SQLException {
		cursor--;
	}
	
	
	/**
	 * End needed methods for this project
	 */
	
	
	
	/**
	 * -----------------------------------------------------------------------------------------------------------------------------
	 * Currently the following methods are not needed for this project
	 */
	
	public boolean absolute(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public void moveToInsertRow() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }
	
	public void afterLast() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public void beforeFirst() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public void cancelRowUpdates() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void clearWarnings() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void close() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void deleteRow() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public int findColumn(String arg0){
		throw new UnsupportedOperationException("Our shit is weak");
		
	}
	
	public Array getArray(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Array getArray(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public InputStream getAsciiStream(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public InputStream getAsciiStream(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public BigDecimal getBigDecimal(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public BigDecimal getBigDecimal(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public BigDecimal getBigDecimal(String arg0, int arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public InputStream getBinaryStream(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public InputStream getBinaryStream(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Blob getBlob(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Blob getBlob(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public boolean getBoolean(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public boolean getBoolean(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public byte getByte(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public byte getByte(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public byte[] getBytes(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public byte[] getBytes(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Reader getCharacterStream(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Reader getCharacterStream(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Clob getClob(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Clob getClob(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public int getConcurrency() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public String getCursorName() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Date getDate(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Date getDate(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Date getDate(int arg0, Calendar arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Date getDate(String arg0, Calendar arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public double getDouble(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public double getDouble(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public int getFetchDirection() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public int getFetchSize() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public float getFloat(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public float getFloat(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public int getInt(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public int getInt(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public long getLong(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public long getLong(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Time getTime(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public Time getTime(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public Time getTime(int arg0, Calendar arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public Time getTime(String arg0, Calendar arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public Timestamp getTimestamp(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public Timestamp getTimestamp(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public Timestamp getTimestamp(String arg0, Calendar arg1)throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public int getType() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public URL getURL(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public URL getURL(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public InputStream getUnicodeStream(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public InputStream getUnicodeStream(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public SQLWarning getWarnings() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void insertRow() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }
	
	public Object getObject(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public Object getObject(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public Object getObject(int arg0, Map<String, Class<?>> arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public Object getObject(String arg0, Map<String, Class<?>> arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public Ref getRef(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public Ref getRef(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public int getRow() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public short getShort(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public short getShort(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public Statement getStatement() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }
	
	public void moveToCurrentRow() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }
	

	public void refreshRow() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public boolean relative(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public boolean rowDeleted() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public boolean rowInserted() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public boolean rowUpdated() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void setFetchDirection(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void setFetchSize(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateArray(int arg0, Array arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateArray(String arg0, Array arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateBigDecimal(String arg0, BigDecimal arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateBlob(int arg0, Blob arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateBlob(String arg0, Blob arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateBoolean(int arg0, boolean arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateBoolean(String arg0, boolean arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateByte(int arg0, byte arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateByte(String arg0, byte arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateBytes(int arg0, byte[] arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateBytes(String arg0, byte[] arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateCharacterStream(String arg0, Reader arg1, int arg2)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateClob(int arg0, Clob arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateClob(String arg0, Clob arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateDate(int arg0, Date arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateDate(String arg0, Date arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateDouble(int arg0, double arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateDouble(String arg0, double arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateFloat(int arg0, float arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateFloat(String arg0, float arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateInt(int arg0, int arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateInt(String arg0, int arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateLong(int arg0, long arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateLong(String arg0, long arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateNull(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateNull(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateObject(int arg0, Object arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateObject(String arg0, Object arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateObject(int arg0, Object arg1, int arg2)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateObject(String arg0, Object arg1, int arg2)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateRef(int arg0, Ref arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateRef(String arg0, Ref arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateRow() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateShort(int arg0, short arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateShort(String arg0, short arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateString(int arg0, String arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateString(String arg0, String arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateTime(int arg0, Time arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateTime(String arg0, Time arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateTimestamp(int arg0, Timestamp arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public void updateTimestamp(String arg0, Timestamp arg1)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public boolean wasNull() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public String getCatalogName(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public String getColumnClassName(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public int getColumnCount(){
		throw new UnsupportedOperationException("Our shit is weak"); }

	public int getColumnDisplaySize(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public String getColumnLabel(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }
	
	public int getPrecision(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public int getScale(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public String getSchemaName(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }
	

	public boolean isAutoIncrement(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public boolean isCaseSensitive(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public boolean isCurrency(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public boolean isDefinitelyWritable(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public int isNullable(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public boolean isReadOnly(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public boolean isSearchable(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public boolean isSigned(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }

	public boolean isWritable(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak"); }
}