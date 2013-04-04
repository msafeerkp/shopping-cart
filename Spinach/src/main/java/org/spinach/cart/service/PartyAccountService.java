package org.spinach.cart.service;

import org.spinach.cart.bean.AccountCreationBean;

public interface PartyAccountService {
	/**
	 * Creates an account for a Party.
	 * @param account
	 */
	public void addParty(AccountCreationBean account);
}
