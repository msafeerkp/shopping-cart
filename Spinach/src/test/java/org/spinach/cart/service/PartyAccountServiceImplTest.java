package org.spinach.cart.service;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spinach.cart.bean.AccountBean;
import org.spinach.cart.exception.CartException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test Class for Party Account Services
 * @author Muhammed Safeer
 *
 */
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PartyAccountServiceImplTest {

	@Resource
	PartyAccountService partyAccountService;
	
	public PartyAccountService getPartyAccountService() {
		return partyAccountService;
	}

	public void setPartyAccountService(PartyAccountService partyAccountService) {
		this.partyAccountService = partyAccountService;
	}

	@Ignore
	@Test
	public void signUp() throws CartException{
		AccountBean signup = new AccountBean();
		signup.setUserId("msafeer@gmail.com");
		signup.setCurrentPassword("welcome*123");
		partyAccountService.signUp(signup);
	}
	
	@Test(expected = CartException.class)
	public void signUpWithNullObject() throws CartException{
		AccountBean signup = new AccountBean();
		partyAccountService.signUp(signup);
	}
	
}
