package com.cg.eis.vaccination.utils;

public class CardNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public CardNotFoundException()
	{
		super("Aadhar Card Not Found....");
	}

}
