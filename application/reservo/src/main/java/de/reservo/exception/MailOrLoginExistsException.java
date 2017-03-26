package de.reservo.exception;

public class MailOrLoginExistsException extends Exception {

	private static final long serialVersionUID = 7139820723110503975L;

	public MailOrLoginExistsException() {
		super();
	}
	
	public MailOrLoginExistsException(String pMessage) {
		super(pMessage);
	}
	
}
