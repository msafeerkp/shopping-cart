package org.spinach.cart.data.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the City database table.
 * @author msafeerkp
 */
@Entity
@Table(name="City")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="city_id", unique=true, nullable=false)
	private int cityId;

	@Column(name="city_name", length=45)
	private String cityName;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="state_id", nullable=false)
	private State state;

	public City() {
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
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

}