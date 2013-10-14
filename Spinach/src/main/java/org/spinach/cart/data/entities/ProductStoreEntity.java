package org.spinach.cart.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.spinach.cart.util.UUIDGenerator;

/**
 * 
 * @author safeer
 * 
 */

@Entity(name="SC_PRODUCT_STORE")
public class ProductStoreEntity {

	@Id
	@Column(name="PRODUCT_STORE_ID")
	private String productStoreId;

	@Column(name="PRODUCT_STORE_NAME",unique=true, nullable=false)
	private String productStoreName;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private AddressEntity address;

	public ProductStoreEntity() {
		this.productStoreId = UUIDGenerator.generate();
	}

	public String getProductStoreId() {
		return productStoreId;
	}

	public void setProductStoreId(String productStoreId) {
		this.productStoreId = productStoreId;
	}

	public String getProductStoreName() {
		return productStoreName;
	}

	public void setProductStoreName(String productStoreName) {
		this.productStoreName = productStoreName;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	@Override
	public String toString() {

		return String.format("org.spinach.cart.data.entities.ProductStoreEntity[id=%s, name=%s, address=%s]",
				productStoreId, productStoreName, address.toString());

	}

}
