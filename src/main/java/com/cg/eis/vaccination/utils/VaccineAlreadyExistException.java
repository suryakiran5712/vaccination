package com.cg.eis.vaccination.utils;

public class VaccineAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public VaccineAlreadyExistException()
	{
		super("Vaccine already exists....");
	}
}
