package org.spinach.cart.exception;

public class CartException extends Exception {

	private static final long serialVersionUID = 3709813962373179680L;

	public CartException() {
		super();
	}

	public CartException(String message) {
		super(message);
	}

	public CartException(Throwable cause) {
		new Exception(cause);
	}

	public CartException(String message, Throwable cause) {
		new Exception(message, cause);
	}
}
