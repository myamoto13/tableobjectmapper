package com.myamoto.exceltoobject4j;

public class ExToObj4jException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5087811101547067476L;
	
	public ExToObj4jException( Throwable throwable) {
		super(throwable.getMessage(), throwable);
	}
	
	public ExToObj4jException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	public ExToObj4jException(String msg) {
		this(msg, null);
	}
	
}
