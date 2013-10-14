package org.spinach.cart.data.repositories;

import org.spinach.cart.data.entities.ProductStoreEntity;

public interface ProductStoreRepository extends GenericRepository<ProductStoreEntity, String>{
	
	/**
	 * Find the Product Store by Name. 
	 * @param name
	 * @return {@link ProductStoreEntity}
	 */
	ProductStoreEntity findByName(String name);
	
}
