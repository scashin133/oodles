package oodles.RMICommon;

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
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

/**
 * This class serves as a starting point for implementing a ResultSet
 * 
 * @author mitch
 *
 */
public abstract class AbstractResultSet implements java.sql.ResultSet, ResultSetMetaData, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean absolute(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

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

	public int findColumn(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public boolean first() throws SQLException {
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

	public ResultSetMetaData getMetaData() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Object getObject(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public Object getObject(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Object getObject(int arg0, Map<String, Class<?>> arg1)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Object getObject(String arg0, Map<String, Class<?>> arg1)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Ref getRef(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Ref getRef(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public int getRow() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public short getShort(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public short getShort(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Statement getStatement() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public String getString(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public String getString(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Time getTime(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Time getTime(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Time getTime(int arg0, Calendar arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Time getTime(String arg0, Calendar arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Timestamp getTimestamp(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Timestamp getTimestamp(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public Timestamp getTimestamp(String arg0, Calendar arg1)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public int getType() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public URL getURL(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public URL getURL(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public InputStream getUnicodeStream(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public InputStream getUnicodeStream(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public SQLWarning getWarnings() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public void insertRow() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public boolean isAfterLast() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public boolean isBeforeFirst() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public boolean isFirst() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public boolean isLast() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public boolean last() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public void moveToCurrentRow() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void moveToInsertRow() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public boolean next() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public boolean previous() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public void refreshRow() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public boolean relative(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public boolean rowDeleted() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public boolean rowInserted() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public boolean rowUpdated() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public void setFetchDirection(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void setFetchSize(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateArray(int arg0, Array arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateArray(String arg0, Array arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateAsciiStream(int arg0, InputStream arg1, int arg2)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateAsciiStream(String arg0, InputStream arg1, int arg2)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateBigDecimal(String arg0, BigDecimal arg1)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateBinaryStream(int arg0, InputStream arg1, int arg2)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateBinaryStream(String arg0, InputStream arg1, int arg2)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateBlob(int arg0, Blob arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateBlob(String arg0, Blob arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateBoolean(int arg0, boolean arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateBoolean(String arg0, boolean arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateByte(int arg0, byte arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateByte(String arg0, byte arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateBytes(int arg0, byte[] arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateBytes(String arg0, byte[] arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateCharacterStream(int arg0, Reader arg1, int arg2)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateCharacterStream(String arg0, Reader arg1, int arg2)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateClob(int arg0, Clob arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateClob(String arg0, Clob arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateDate(int arg0, Date arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateDate(String arg0, Date arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateDouble(int arg0, double arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateDouble(String arg0, double arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateFloat(int arg0, float arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateFloat(String arg0, float arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateInt(int arg0, int arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateInt(String arg0, int arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateLong(int arg0, long arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateLong(String arg0, long arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateNull(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateNull(String arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateObject(int arg0, Object arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateObject(String arg0, Object arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateObject(int arg0, Object arg1, int arg2)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateObject(String arg0, Object arg1, int arg2)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateRef(int arg0, Ref arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateRef(String arg0, Ref arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateRow() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateShort(int arg0, short arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateShort(String arg0, short arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateString(int arg0, String arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateString(String arg0, String arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateTime(int arg0, Time arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateTime(String arg0, Time arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateTimestamp(int arg0, Timestamp arg1) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public void updateTimestamp(String arg0, Timestamp arg1)
			throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");

	}

	public boolean wasNull() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public String getCatalogName(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public String getColumnClassName(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
		
	}

	public int getColumnCount() throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public int getColumnDisplaySize(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public String getColumnLabel(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public String getColumnName(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public int getColumnType(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public String getColumnTypeName(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public int getPrecision(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public int getScale(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public String getSchemaName(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public String getTableName(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public boolean isAutoIncrement(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public boolean isCaseSensitive(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public boolean isCurrency(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public boolean isDefinitelyWritable(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public int isNullable(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public boolean isReadOnly(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public boolean isSearchable(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public boolean isSigned(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

	public boolean isWritable(int arg0) throws SQLException {
		throw new UnsupportedOperationException("Our shit is weak");
	}

}
