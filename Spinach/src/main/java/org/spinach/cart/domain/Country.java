package org.spinach.cart.domain;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.*;

import org.spinach.cart.repository.CountryRepository;
import org.spinach.cart.util.UUIDGenerator;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * The persistent class for the Country database table.
 * @author Muhammed Safeer
 */
@Entity
@Table(name="Country")
@Component("country")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="country_id",columnDefinition = "BINARY(16)", length = 16, updatable = false, nullable = false)
	private byte[] id;

	@Column(name="country_name", nullable=false, length=45)
	private String countryName;

	//bi-directional many-to-one association to State
	@OneToMany(mappedBy="country")
	private List<State> states;
	
	@Transient
	@Resource
	private CountryRepository countryRepository;
	
	public Country() {
	}

	public byte[] getId() {
		return id;
	}

	public void setId(byte[] id) {
		this.id = id;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<State> getStates() {
		return this.states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public State addState(State state) {
		getStates().add(state);
		state.setCountry(this);

		return state;
	}

	public State removeState(State state) {
		getStates().remove(state);
		state.setCountry(null);

		return state;
	}

	public CountryRepository getCountryRepository() {
		return countryRepository;
	}

	public void setCountryRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	public void add(Country country){
		countryRepository.save(country);
	}
	
	@PrePersist
	public void setUuid(){
		if(this.id == null){
			this.id = UUIDGenerator.getuuid();
		}
	}
}