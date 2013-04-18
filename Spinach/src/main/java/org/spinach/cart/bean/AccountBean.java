package org.spinach.cart.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.spinach.cart.exception.CartException;
import org.spinach.cart.service.PartyAccountService;

@ManagedBean(name = "accountCreation")
public class AccountBean extends BaseBean{
	
	private String userId;
	private String currentPassword;
	
	@ManagedProperty(value = "#{partyAccountService}")
	PartyAccountService accountService;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public PartyAccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(PartyAccountService accountService) {
		this.accountService = accountService;
	}

	public void createAccount() throws CartException{
		accountService.signUp(this);
	}

}
