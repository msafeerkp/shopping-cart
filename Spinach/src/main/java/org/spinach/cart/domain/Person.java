package org.spinach.cart.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * The persistent class for the Person database table.
 * 
 */
@Component("person")
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

	//bi-directional one-to-one association to Party
	@OneToOne
	@JoinColumn(name="partyId", referencedColumnName = "partyId")
	private Party party;

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

	public Party getParty() {
		return this.party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

}