package org.spinach.cart.service;

import java.util.Date;

import javax.annotation.Resource;

import org.spinach.cart.bean.AccountCreationBean;
import org.spinach.cart.domain.Party;
import org.spinach.cart.domain.Person;
import org.spinach.cart.domain.UserLogin;
import org.spinach.cart.mapper.PartyMapper;
import org.spinach.cart.util.UUIDGenerator;
import org.springframework.stereotype.Component;

@Component("partyAccountService")
public class PartyAccountServiceImpl implements PartyAccountService{

	private static final String DISABLED = "N";

	@Resource
	PartyMapper partyMapper;
	
	@Resource
	Party party;
	
	public PartyMapper getPartyMapper() {
		return partyMapper;
	}

	public void setPartyMapper(PartyMapper partyMapper) {
		this.partyMapper = partyMapper;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	@Override
	public void addParty(AccountCreationBean account) {
		UserLogin userLogin= partyMapper.getUserLogin(account);
		Party party = new Party();
		Person person = new Person();
		party.setPartyId(UUIDGenerator.getuuid());
		party.setCreatedOn(new Date());
		person.setPersonId(UUIDGenerator.getuuid());
		userLogin.setUserId(UUIDGenerator.getuuid());
		party.setUserLogin(userLogin);
		party.setPerson(person);
		person.setParty(party);
		userLogin.setParty(party);
		userLogin.setEnabled(DISABLED);
		this.party.addParty(party);
	}
}
