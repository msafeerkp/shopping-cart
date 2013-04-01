package org.spinach.cart.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spinach.cart.util.UUIDGenerator;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import antlr.collections.List;

@Profile("test")
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class PartyTest {

	@Resource
	Party party1;
	
	@Resource 
	Person person;
	
	public Party getParty() {
		return party1;
	}

	public void setParty(Party party) {
		this.party1 = party;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Test
	public void addParty(){
		//Person person = new Person();
		Party party = new Party();
		person.setPersonId(UUIDGenerator.getuuid());
		person.setFirstName("Muhammed");
		
		
		UserLogin userlogin =  new UserLogin();
		userlogin.setUserId(UUIDGenerator.getuuid());
		userlogin.setUserLoginId("msafeerkp@gmail.com");
		userlogin.setCurrentPassword("welcome*123");
		userlogin.setEnabled("N");
		userlogin.setHasLoggedIn("N");
		
		
		party.setPartyId(UUIDGenerator.getuuid());
		party.setCreatedOn(new Date());
		party.setPerson(person);
		//party.setUserLogin(userlogin);
		
		person.setParty(party);
		//userlogin.setParty(party);
		
		person.getPersonRepository().save(person);
		party1.getPartyRepository().save(party);
		
	}

}
