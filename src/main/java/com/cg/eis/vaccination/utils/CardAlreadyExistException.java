package com.cg.eis.vaccination.utils;

public class CardAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public CardAlreadyExistException() {
		super("Aadhar card already exists....");
	}
}
