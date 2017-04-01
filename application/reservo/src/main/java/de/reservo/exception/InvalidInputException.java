package de.reservo.exception;

public class InvalidInputException extends Exception {

	private static final long serialVersionUID = -8898181882390440425L;
	
	public InvalidInputException() {
		super();
	}
	
	public InvalidInputException(String pMessage) {
		super(pMessage);
	}

}
