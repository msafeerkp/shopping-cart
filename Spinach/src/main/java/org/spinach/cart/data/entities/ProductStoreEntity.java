package org.spinach.cart.data.entities;

import org.spinach.cart.data.vo.AddressVO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author safeer
 * 
 */

@Document(collection = "product_store")
public class ProductStoreEntity {

	@Id
	private String id;

	@Indexed(unique = true)
	private String name;

	private AddressVO address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	@Override
	public String toString() {

		return String.format("org.spinach.cart.data.entities.ProductStoreEntity[id=%s, name=%s, address=%s]",
				id, name, address.toString());

	}

}
