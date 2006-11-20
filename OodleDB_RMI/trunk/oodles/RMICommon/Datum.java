package oodles.RMICommon;

import java.io.Serializable;

/**
 * This class represents a possible extension point for passing
 * meta-information with individual pieces of data; think of a
 * 'cell' in a SQL table.
 * 
 * @author mitch
 *
 */
public class Datum implements Serializable {

	/**
	 * Serial Version ID :P for serialization!
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The 'payload' of this datum
	 */
	private Object value;


	public Object getValue() {
		return value;
	}

	public void setData(Object value) {
		this.value = value;
	}
	
	
	
	

}
