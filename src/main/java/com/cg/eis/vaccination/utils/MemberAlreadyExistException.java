package com.cg.eis.vaccination.utils;

public class MemberAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public MemberAlreadyExistException()
	{
		super("Member Already Exist....");
	}

}
