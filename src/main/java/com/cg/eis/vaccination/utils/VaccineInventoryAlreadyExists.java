package com.cg.eis.vaccination.utils;

public class VaccineInventoryAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public VaccineInventoryAlreadyExists()
	{
		super("Vaccine Inventory Already Exists.....");
	}

}
