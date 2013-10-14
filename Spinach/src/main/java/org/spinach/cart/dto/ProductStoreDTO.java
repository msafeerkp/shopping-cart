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
@XmlRootElement(name = "product_store")
public class ProductStoreDTO {

	@XmlElement(name = "product_store_id")
	protected String productStoreid;
	
	@XmlElement(name = "product_store_name")
	protected String productStoreName;

	@XmlElement(name = "address")
	protected AddressDTO address;

	public String getProductStoreid() {
		return productStoreid;
	}

	public void setProductStoreid(String productStoreid) {
		this.productStoreid = productStoreid;
	}

	public String getProductStoreName() {
		return productStoreName;
	}

	public void setProductStoreName(String productStoreName) {
		this.productStoreName = productStoreName;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	@Override
	public String toString() {

		return String
				.format("org.spinach.cart.data.entities.ProductStoreEntity[id=%s, name=%s, address=%s]",
						productStoreid, productStoreName, address.toString());

	}

}
