package com.cg.eis.vaccination.utils;

public class NoMembersFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public NoMembersFoundException()
	{
		super("No Members Found...");
	}

}
