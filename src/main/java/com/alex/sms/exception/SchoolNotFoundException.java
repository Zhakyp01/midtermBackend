package com.alex.sms.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class SchoolNotFoundException.
 */
public class SchoolNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new school not found exception.
	 *
	 * @param id the id
	 */
	public SchoolNotFoundException(Integer id) {
		super(String.format("School with id '%s' could not be found.", id));
	}

}
