package org.spinach.cart.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.spinach.cart.util.UUIDGenerator;

/**
 * 
 * @author safeer
 * 
 */
@Entity(name="SC_ADDRESS")
public class AddressEntity {

	
	@Id
	@Column(name="ADDRESS_ID")
	private String addressId;
	
	private String phone;
	private String address;
	private String postalCode;
	private String city;
	private String country;
	private String state;

	public AddressEntity() {
		this.addressId = UUIDGenerator.generate();
	}
	
	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {

		return String
				.format("org.spinach.cart.data.vo.Address[phone=%s, address=%s, postalCode=%s, city=%s, country=%s, state=%s]",
						phone, address, postalCode, city, country, state);

	}

}
