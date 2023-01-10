package com.cg.eis.vaccination.utils;

public class VaccineInventoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public VaccineInventoryNotFoundException()
	{
		super("Vaccine Inventory Not Found.....");
	}

}
