package org.spinach.cart.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Person database table.
 * 
 */
@Entity
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String personId;

	@Temporal(TemporalType.DATE)
	private Date birthDate;

	private String firstName;

	private String gender;

	private String lastName;

	//bi-directional many-to-one association to Party
	@OneToMany(mappedBy="person")
	private List<Party> parties;

	public Person() {
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Party> getParties() {
		return this.parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}

	public Party addParty(Party party) {
		getParties().add(party);
		party.setPerson(this);

		return party;
	}

	public Party removeParty(Party party) {
		getParties().remove(party);
		party.setPerson(null);

		return party;
	}

}