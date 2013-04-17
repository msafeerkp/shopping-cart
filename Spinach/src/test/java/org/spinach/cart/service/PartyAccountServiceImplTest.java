package org.spinach.cart.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spinach.cart.bean.AccountBean;
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
	
	@Test
	public void signUp(){
		AccountBean signup = new AccountBean();
		signup.setUserLoginId("msafeer@gmail.com");
		signup.setCurrentPassword("welcome*123");
	}
	
}
