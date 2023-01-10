package com.cg.eis.vaccination.utils;

public class VaccineRegNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public VaccineRegNotFoundException()
	{
		super("Vaccine Registration Not Found....");
	}

}
