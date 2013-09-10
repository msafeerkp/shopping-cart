package org.spinach.cart.exception;

public class CartDataAccessException extends RuntimeException{
	
	private static final long serialVersionUID = 542827073942947008L;

	public CartDataAccessException() {
		super();
	}
	public CartDataAccessException(String message) {
		super(message);
	}
	
	public CartDataAccessException(String message, Throwable cause){
		super(message, cause);
	}
	
	
	
}
