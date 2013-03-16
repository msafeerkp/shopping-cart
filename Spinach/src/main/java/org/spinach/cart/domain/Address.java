package org.spinach.cart.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Address database table.
 * @author Muhammed Safeer
 * 
 */
@Entity
@Table(name="Address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_id", unique=true, nullable=false)
	private int addressId;

	@Column(length=45)
	private String city;

	@Column(length=45)
	private String country;

	@Column(name="land_line", length=16)
	private String landLine;

	@Column(length=45)
	private String landmark;

	@Column(name="phone_number", length=16)
	private String phoneNumber;

	@Column(length=12)
	private String pincode;

	@Column(length=45)
	private String state;

	@Column(name="street_address", length=220)
	private String streetAddress;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLandLine() {
		return this.landLine;
	}

	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}

	public String getLandmark() {
		return this.landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}