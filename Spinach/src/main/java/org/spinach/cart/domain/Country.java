package org.spinach.cart.domain;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.*;

import org.spinach.cart.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="country_id", unique=true, nullable=false)
	private int countryId;

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

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
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
}