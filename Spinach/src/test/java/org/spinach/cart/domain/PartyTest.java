package org.spinach.cart.domain;



import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spinach.cart.exception.CartException;
import org.spinach.cart.util.UUIDGenerator;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@Profile("test")
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class PartyTest {

	@Resource
	Party party1;
		
	public Party getParty() {
		return party1;
	}

	public void setParty(Party party) {
		this.party1 = party;
	}

	@Test
	public void addParty() throws CartException{
		Person person = new Person();
		Party party = new Party();
		person.setPersonId(UUIDGenerator.getuuid());
		person.setFirstName("Muhammed");
		
		
		UserLogin userlogin =  new UserLogin();
		userlogin.setUserId("msafeerkp@gmail.com");
		userlogin.setUserLoginId(UUIDGenerator.getuuid());
		userlogin.setCurrentPassword("welcome*123");
		userlogin.setEnabled("N");
		
		
		party.setPartyId(UUIDGenerator.getuuid());
		party.setCreatedOn(new Date());
		party.setPerson(person);
		party.setUserLogin(userlogin);
		
		userlogin.setParty(party);
		person.setParty(party);
		party1.addParty(party);
		
	}

}
