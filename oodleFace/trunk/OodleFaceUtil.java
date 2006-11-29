import java.util.Scanner;
import java.util.regex.Pattern;


public class OodleFaceUtil {
	public static String getTableName(String command){
		Scanner s = new Scanner(command);
		// Look for a statement that preceeds a table name
		while (s.hasNext() && !s.hasNext(Pattern.compile("FROM|TABLE|INTO|ON"))){
			s.next();
		}
		// If the loop exits, there's either table name or
		// its reached the end of the String
		if (s.hasNext()){
			// burn the preceeding token
			// and take the next as the table name
			s.next();
			String tableName = s.next();
			System.out.println("Table Name: " + tableName);
			return tableName;
		}
		
		// Otherwise, there was no token found, and an error message
		// needs to be displayed.  Return null.
		else {
			return null;
		}
	}
}
