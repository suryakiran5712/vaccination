package com.cg.eis.vaccination.utils;

public class VaccinationCenterNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public VaccinationCenterNotFoundException()
	{
		super("Vaccination Center Not Found....");
	}

}
