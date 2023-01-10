package com.cg.eis.vaccination.utils;

public class MemberNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public MemberNotFoundException()
	{
		super("Member Not Found....");
	}

}
