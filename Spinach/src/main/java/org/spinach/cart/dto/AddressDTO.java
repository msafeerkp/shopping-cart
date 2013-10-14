package org.spinach.cart.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author safeer
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address")
public class AddressDTO {
	
	@XmlElement(name = "address_id")
	protected String addressId;
	
	@XmlElement(name = "phone")
	protected String phone;

	@XmlElement(name = "address")
	protected String address;

	@XmlElement(name = "postal_code")
	protected String postalCode;

	@XmlElement(name = "city")
	protected String city;

	@XmlElement(name = "country")
	protected String country;

	@XmlElement(name = "state")
	protected String state;

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
				.format("org.spinach.cart.dto.Address[phone=%s, address=%s, postalCode=%s, city=%s, country=%s, state=%s]",
						phone, address, postalCode, city, country, state);

	}

}
