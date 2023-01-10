package com.cg.eis.vaccination.utils;

public class VaccinationCenterAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public VaccinationCenterAlreadyExistException()
	{
		super("Vaccination Center Already Exist.....");
	}

}
