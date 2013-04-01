package org.spinach.cart.domain;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.*;

import org.spinach.cart.repository.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Person database table.
 * @author Muhammed Safeer
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
	
	@Transient
	@Resource
	public PersonRepository personRepository;
	

	//bi-directional many-to-one association to Party
	@OneToOne
	@PrimaryKeyJoinColumn
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
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	

}