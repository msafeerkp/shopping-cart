package org.spinach.cart.data.repositories;

import java.util.Iterator;

import org.spinach.cart.data.entities.ProductStoreEntity;
import org.springframework.stereotype.Repository;



@Repository(value="productStoreRepository")
public class ProductStoreRepositoryImp extends GenericRepositoryImpl<ProductStoreEntity, String> implements ProductStoreRepository{
	
	public ProductStoreRepositoryImp() {
		super();
	}
	
	@Override
	public ProductStoreEntity findByName(String name) {
		Iterable<ProductStoreEntity> productStoreEntities = findByColumnName("productStoreName", name);
		Iterator<ProductStoreEntity> iterator = productStoreEntities.iterator();
		ProductStoreEntity productStoreEntity = null;
		if(iterator.hasNext()){
			productStoreEntity = iterator.next();
		}
		return productStoreEntity;
	}
	
	
}
