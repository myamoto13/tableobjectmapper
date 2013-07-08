package com.myamoto.exceltoobject4j.dao;

public class ExToObj4jDAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5087811101547067476L;

	public ExToObj4jDAOException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	public ExToObj4jDAOException(String msg) {
		this(msg, null);
	}
	
}
