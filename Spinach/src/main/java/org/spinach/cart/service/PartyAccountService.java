package org.spinach.cart.service;

import org.spinach.cart.bean.AccountBean;
import org.spinach.cart.exception.CartException;
/**
 * 
 * @author Muhammed Safeer
 *
 */
public interface PartyAccountService {
	/***
	 * Creates an Account for the requested User.
	 * @param account - User Details are stored as an object of {@link AccountBean} Class.
	 * @throws CartException
	 */
	public void signUp(AccountBean account) throws CartException;
	
	/***
	 * Perform the Login Operation
	 * @param account - User Details are stored as an object of {@link AccountBean} Class.
	 * @return returns true if the User Login process is successful. return false if Login process is not successful.
	 * @throws CartException
	 */
	public boolean login(AccountBean account) throws CartException;
}
