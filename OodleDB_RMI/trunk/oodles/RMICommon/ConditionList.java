package oodles.RMICommon;

/**
 * This class is the interface for a tree of predicates.
 * 
 * @author mitch
 *
 */
public interface ConditionList {

	public void add(ConditionList cl);
	
	/**
	 * Evaluates a row against the condition list.
	 * 
	 * And no, we don't know what a Row is either...
	 * 
	 * @param r the row
	 * @return True if the conditionlist matches this row, or false otherwise
	 */
	public boolean evaluate(Row r);
	
	
}
