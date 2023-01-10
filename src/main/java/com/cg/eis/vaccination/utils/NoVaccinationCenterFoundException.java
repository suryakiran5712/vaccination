package com.cg.eis.vaccination.utils;

public class NoVaccinationCenterFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public NoVaccinationCenterFoundException()
	{
		super("Vaccination Centers are not available.....");
	}

}
