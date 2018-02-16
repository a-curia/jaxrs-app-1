package com.dbbyte.rest.exception;


public class DataNotFoundException extends RuntimeException {
	
	// to map this exception to ErrorMessage response we use ExceptionMapper

	/**
	 * 
	 */
	private static final long serialVersionUID = -5699510165062564125L;

//	public DataNotFoundException() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public DataNotFoundException(String message, Throwable cause, boolean enableSuppression,
//			boolean writableStackTrace) {
//		super(message, cause, enableSuppression, writableStackTrace);
//		// TODO Auto-generated constructor stub
//	}
//
//	public DataNotFoundException(String message, Throwable cause) {
//		super(message, cause);
//		// TODO Auto-generated constructor stub
//	}

	public DataNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

//	public DataNotFoundException(Throwable cause) {
//		super(cause);
//		// TODO Auto-generated constructor stub
//	}
//	
	

}
