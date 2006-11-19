import java.util.ArrayList;
import javax.swing.JTable;

// This class basically serves as a go between for SQL commands leaving
// the DataPanel and going to the SQLExecutor.  At the moment it's small
// since it just passes command through it.  Not sure what functionality
// could/was meant to be added here...
public class SQLExecutionListener {
	
	SQLExecutor executor; 
	
	public SQLExecutionListener(SQLExecutor sqle){
		executor = sqle;
	}
	
	public JTable executeSQL(ArrayList<String> commands, String tableName){
		return executor.executeSQL(commands);
	}
	
}
