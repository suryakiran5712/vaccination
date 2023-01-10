package com.cg.eis.vaccination.utils;

public class FillInventoryDetailsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public FillInventoryDetailsException()
	{
		super("No Inventory is Mapped to Vaccination Center....");
	}

}
