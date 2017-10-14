package com.farm.exception;

public class FarmAppException extends Exception {
	private static final long serialVersionUID = 8930564996727710079L;

	public FarmAppException() {
		super();
	}

	public FarmAppException(String errMessage) {
		super(errMessage);
	}

}
