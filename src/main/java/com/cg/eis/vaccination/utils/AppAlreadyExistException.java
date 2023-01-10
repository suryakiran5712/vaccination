package com.cg.eis.vaccination.utils;

public class AppAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public AppAlreadyExistException()
	{
		super("Appointment Already Exist....");
	}

}
