package com.cg.eis.vaccination.utils;

public class VaccineNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public VaccineNotFoundException()
	{
		super("Vaccine not found....");
	}
}
