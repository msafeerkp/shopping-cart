package org.spinach.cart.data.repositories;

import org.spinach.cart.data.entities.ProductStoreEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductStoreRepository extends MongoRepository<ProductStoreEntity, Long>{
	
	/**
	 * Find the Product Store by Name. 
	 * @param name
	 * @return {@link ProductStoreEntity}
	 */
	ProductStoreEntity findByName(String name);
	
}
