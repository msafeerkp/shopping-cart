package org.spinach.cart.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author safeer
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="product_store")
public class ProductStoreDTO extends CartDTO{
	
	@XmlElement(name="name")
	protected String name;
	
	@XmlElement(name="address")
	protected AddressDTO address;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
}
