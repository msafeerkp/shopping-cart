package org.spinach.cart.domain;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.*;

import org.spinach.cart.repository.CityRepository;
import org.spinach.cart.util.UUIDGenerator;
import org.springframework.stereotype.Component;


/**
 * The persistent class for the City database table.
 * @author Muhammed Safeer
 */
@Entity
@Table(name="City")
@Component("city")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "BINARY(16)", length = 16, updatable = false, nullable = false)
	private byte[] id;

	@Column(name="city_name", length=45)
	private String cityName;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="state_id", nullable=false)
	private State state;

	@Transient
	@Resource
	private CityRepository cityRepository;
	
	public City() {
	}



	public byte[] getId() {
		if(this.id != null){
			UUIDGenerator.byteTouuid(this.id);
		}
		return id;
	}


	public void setId(byte[] id) {
		this.id = id;
	}


	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public CityRepository getCityRepository() {
		return cityRepository;
	}

	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	public void Add(City city){
		cityRepository.save(city);
	}
	
	@PrePersist
	public void setUuid(){
		if(this.id == null){
			this.id = UUIDGenerator.getuuid();
		}
	}
}