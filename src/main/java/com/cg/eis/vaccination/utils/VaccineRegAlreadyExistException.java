package com.cg.eis.vaccination.utils;

public class VaccineRegAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public VaccineRegAlreadyExistException()
	{
		super("Vaccine Registration Already Exist....");
	}

}
