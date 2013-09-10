package org.spinach.cart.data.repositories;

import org.spinach.cart.data.entities.ProductStoreEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductStoreRepository extends CrudRepository<ProductStoreEntity, Long>{
	
}
