package com.cg.eis.vaccination.utils;

public class VaccinationInvalidDetailsException extends RuntimeException  {
	private static final long serialVersionUID = 1L;
 
	public VaccinationInvalidDetailsException()
	{
		super("Please enter the valid details");
	}
}
