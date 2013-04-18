package org.spinach.cart.service;

import org.spinach.cart.bean.AccountBean;
import org.spinach.cart.exception.CartException;
/**
 * 
 * @author Muhammed Safeer
 *
 */
public interface PartyAccountService {
	/**
	 * Creates an account for a Party.
	 * @param account
	 */
	public void signUp(AccountBean account) throws CartException;
}
