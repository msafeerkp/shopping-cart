package org.spinach.cart.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spinach.cart.dto.CustomerAccountCreationDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Profile("test")
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class CustomerAccountCreationTest {
	
	@Test
	public void add(String[] args) {
		CustomerAccountCreationService service =new CustomerAccountCreationServiceImpl();
		CustomerAccountCreationDTO dto = new CustomerAccountCreationDTO();
		dto.setEmailID("safeerkp@live.com");
		dto.setPassword("safeer");
		dto.setConfirmPassword("safeer");
		service.addCustomer(dto);
	}
}
