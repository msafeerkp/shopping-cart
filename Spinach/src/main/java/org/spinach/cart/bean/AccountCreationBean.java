package org.spinach.cart.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.spinach.cart.service.PartyAccountService;

@ManagedBean(name = "accountCreation")
public class AccountCreationBean extends BaseBean{
	
	private String userLoginId;
	private String currentPassword;
	
	@ManagedProperty(value = "#{partyAccountService}")
	PartyAccountService accountService;

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
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

	public void createAccount(){
		accountService.addParty(this);
	}

}
