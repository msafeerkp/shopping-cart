package org.spinach.cart.data.entities;

import org.spinach.cart.data.vo.AddressVO;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author safeer
 *
 */

@Document(collection="product_store")
public class ProductStoreEntity {
	
	@Indexed(unique=true)
	private String name;
	
	private AddressVO address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AddressVO getAddress() {
		return address;
	}
	public void setAddress(AddressVO address) {
		this.address = address;
	}
	
}
