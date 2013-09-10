package org.spinach.cart.exception;

public class CartServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 3352144240105906597L;

	public CartServiceException() {
		super();
	}
	public CartServiceException(String message) {
		super(message);
	}
	
	public CartServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
