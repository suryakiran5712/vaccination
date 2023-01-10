package com.cg.eis.vaccination.utils;

public class NoRecordsFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public NoRecordsFoundException()
	{
		super("Vaccines are not available....");
	}

}
