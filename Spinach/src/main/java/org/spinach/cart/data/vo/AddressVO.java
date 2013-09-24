package org.spinach.cart.data.vo;

/**
 * 
 * @author safeer
 * 
 */
public class AddressVO {

	private String phone;
	private String address;
	private String postalCode;
	private String city;
	private String country;
	private String state;

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
