package org.spinach.cart.domain;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.*;

import org.spinach.cart.repository.PartyRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


/**
 *  
 * The persistent class for the Party database table.
 * @author Muhammed Safeer
 */
@Component("party")
@Entity
public class Party implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String partyId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ModifiedOn")
	private Date modifiedOn;

	//bi-directional many-to-one association to Person
	@OneToOne(mappedBy="party")
	private Person person;

	//bi-directional many-to-one association to UserLogin
	@OneToOne(mappedBy="party")
	private UserLogin userLogin;

	//bi-directional many-to-one association to PartyContactMech
	@OneToMany(mappedBy="party")
	private List<PartyContactMech> partyContactMeches;

	//bi-directional many-to-one association to PartyRole
	@OneToMany(mappedBy="party")
	private List<PartyRole> partyRoles;

	@Transient
	@Resource
	public PartyRepository partyRepository;
	
	public Party() {
	}

	public String getPartyId() {
		return this.partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public UserLogin getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	public List<PartyContactMech> getPartyContactMeches() {
		return this.partyContactMeches;
	}

	public void setPartyContactMeches(List<PartyContactMech> partyContactMeches) {
		this.partyContactMeches = partyContactMeches;
	}

	public PartyContactMech addPartyContactMech(PartyContactMech partyContactMech) {
		getPartyContactMeches().add(partyContactMech);
		partyContactMech.setParty(this);

		return partyContactMech;
	}

	public PartyContactMech removePartyContactMech(PartyContactMech partyContactMech) {
		getPartyContactMeches().remove(partyContactMech);
		partyContactMech.setParty(null);

		return partyContactMech;
	}

	public List<PartyRole> getPartyRoles() {
		return this.partyRoles;
	}

	public void setPartyRoles(List<PartyRole> partyRoles) {
		this.partyRoles = partyRoles;
	}

	public PartyRole addPartyRole(PartyRole partyRole) {
		getPartyRoles().add(partyRole);
		partyRole.setParty(this);

		return partyRole;
	}

	public PartyRole removePartyRole(PartyRole partyRole) {
		getPartyRoles().remove(partyRole);
		partyRole.setParty(null);

		return partyRole;
	}

	public PartyRepository getPartyRepository() {
		return partyRepository;
	}

	public void setPartyRepository(PartyRepository partyRepository) {
		this.partyRepository = partyRepository;
	}	
}