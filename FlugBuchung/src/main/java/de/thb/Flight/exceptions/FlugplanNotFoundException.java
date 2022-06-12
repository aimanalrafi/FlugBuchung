package de.thb.Flight.exceptions;

public class FlugplanNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlugplanNotFoundException(String str) {
		super(str);
	}

}
