package org.spinach.cart.controller;

import org.spinach.cart.bean.AccountCreationBean;
import org.springframework.stereotype.Component;

@Component("accountController")
public class AccountController {
	
	public AccountCreationBean createAccount(){
		AccountCreationBean account = new AccountCreationBean();
		return account;
	}
}
