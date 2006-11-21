package oodles.RMICommon;

import java.rmi.Remote;
import java.sql.*;
import java.util.Collection;


/**
 * Provides an interface for interacting with a database over RMI.
 */
public interface RemoteDatabase extends Remote {

	/**

	* Maps to the SELECT SQL Statement.  If the conditions given is null then will not apply any conditions to
	* query and will return all of the columns requested.
	*
	* @param tableName the name of the table from which you are selecting from
	* @param namesOfSelectedColumns a list of the names of the columns that will be shown in the returned ResultSet
	* @param conditions the data structure used for storing SQL conditions in a easy to use way, see ConditionList for more information
	* @return the resultset generated by the query given or throws SQLException if error
	* @see ResultSet
	* @see ConditionList
	*
	*/
	public ResultSet select(String tableName, Collection<String> columns, String whereClause) throws SQLException;

	/**
	* Maps to the CREATE TABLE SQL Statement.  Must be at least one ColumnSchema given.  The tablename given may NOT be one already in existence,
	* or else an error will be thrown.
	*
	* @param tableName the name of the table you are inserting
	* @param schemaForColumns list all of the
	* @return 0 because no rows have been updated or throws SQLException if error
	* @see ColumnSchema
	*
	*/
	public int createTable(String tableName, Collection<ColumnSchema> columns) throws SQLException;

	/**
	* Maps to the ALTER TABLE SQL Statement.  Used for when altering the schema of a table.
	* The tablename must be a table in the database.
	*
	* @param tableName name of the table that is wanting to be altered
	* @param columnSchemaToBeAdded schema for the column wishing to be added to the table
	* @return 0 because no rows are being updated or throws SQLException if error
	* @see ColumnSchema
	*
	*/
	public int alterTable(String tableName, ColumnSchema columnSchemaToBeAdded) throws SQLException;

	/**
	* Maps to the UPDATE SQL Statement.  The tablename must be a table in the database.  Will update all rows that are approved by the ConditionList.
	* The list of columnNames and newValues must be of the same size and order.
	*
	* @param tableName name of the table that is wanting to be updated
	* @param columnNames list of columnNames that are going to be the columns updated in the row
	* @param newValues list of values that are going to be the new values in the row for the corresponding columns
	* @param conditions conditions that must be meet inorder for the row to be updated
	* @return number of rows that have been changed by this command or throws SQLException if error
	* @see Datum
	* @see ConditionList
	*
	*/
	public int update(String tableName, Collection<String> columnNames, Collection<String> newValues, String whereClause) throws SQLException;

	/**
	* Maps to the INSERT INTO SQL Statement.  The tablename must be a table in the database.  If the list of columnNames is null then the
	* list of values must be equal to the total number of columns in the row it is being inserted.  If the list of columnNames is not null, then
	* the number of columnNames must be the same as the number of values and they must be in order.
	*
	* @param tablename name of the table that is wanting to be inserted into
	* @param columnNames Names of the columns that are going to be inserted into with the corresponding values
	* @param values list of Data that is in the order of the columns specified unless the list of columnNames is null.  In which case,
	* it is a list of Data that is in order of the total number of columns in this table.
	* @return number of rows that have been changed by this command or throws SQLException if error
	* @see Datum
	*
	*/
	public int insert(String tableName, Collection<String> columnNames, Collection<String> values) throws SQLException;


	/**
	* Maps to the DELETE SQL Statement.  The tablename must be a table in the database.  Will delete all rows that satisfy the ConditionList.
	*
	* @param tableName name of the table that is wanting to be deleted from
	* @param conditions the conditions that must be meet inorder to delete a row from a table
	* @return number of rows that have been changed by this command or throws SQLException if error
	* @see ConditionList
	*
	*/
	public int delete(String tableName, String whereClause) throws SQLException;

	/**
	* Maps to the TRUNCATE SQL Statement or the SQL Statement DELETE * FROM <tablename>.  The name of the table must exist in the database.
	*
	* @param tableName name of the table that is wanting to have all of its data deleted
	* @return number of rows that have been changed by this command or throws SQLException if error
	*
	*/
	public int deleteAllFromTable(String tableName) throws SQLException;


	/**
	* Maps to the DROP TABLE SQL Statement.  Will remove all trace of the table NOT just the data underneath.  The name of the table must exist.
	*
	* @param tablename name of the table that is wanting to be deleted.  All information about table deleted.
	* @return 0 because deleting whole table or throws SQLException if error
	*/
	public int dropTable(String tableName) throws SQLException;
	
	
	/**
	 * Maps to the DESCRIBE [table] SQL command. Returns result set containing table schema information:
	 * 
	 * Columns Returned:
	 * - Field: The name of the field
	 * - Type: The type of the field
	 * - Key: Whether or not this column is the primary key
	 * 
	 * @param tableName The name of the table to destribe
	 * @throws SQLException as usual.
	 */
	public ResultSet describeTable(String tableName) throws SQLException;
	
	
	/**
	 * Maps to the SHOW TABLES SQL command. Returns a resultset listing the names of all the tables within the database.
	 * 
	 * Columns Returned:
	 * - Table: The name of the table
	 * 
	 * @thows SQLException
	 */
	public ResultSet showTables() throws SQLException;
	

}