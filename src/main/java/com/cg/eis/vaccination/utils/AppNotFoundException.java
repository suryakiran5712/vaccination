package com.cg.eis.vaccination.utils;

public class AppNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public AppNotFoundException()
	{
		super("Appointment Not Found....");
	}

}
