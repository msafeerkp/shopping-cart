package org.spinach.cart.data.entities;

import javax.annotation.Resource;

import org.spinach.cart.data.vo.Address;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author safeer
 *
 */

@Document(collection="productStore")
public class ProductStore {
	
	private String name;
	private Address address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
