package org.spinach.cart.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spinach.cart.data.entities.ProductStoreEntity;
import org.spinach.cart.data.repositories.ProductStoreRepository;
import org.spinach.cart.dto.ProductStoreDTO;
import org.spinach.cart.exception.CartDataAccessException;
import org.spinach.cart.exception.CartServiceException;
import org.springframework.dao.DuplicateKeyException;

@Named("productStoreService")
public class ProductStoreService {

	Logger logger = LoggerFactory.getLogger(ProductStoreService.class);

	@Inject
	ProductStoreRepository productStoreRepository;

	@Inject
	DozerBeanMapper mapper;

	/**
	 * Create a Data Warehouse with given details.
	 * 
	 * @param productStoreDTO
	 * @throws CartServiceException
	 */
	public ProductStoreDTO createProductStore(ProductStoreDTO productStoreDTO)
			throws CartServiceException {
		try {
			
			ProductStoreEntity productStoreEntity = mapper.map(productStoreDTO,
					ProductStoreEntity.class);
			
			ProductStoreEntity persistedStoreEntity = productStoreRepository
					.save(productStoreEntity);
			
			ProductStoreDTO persistedStoreDTO = mapper.map(persistedStoreEntity, ProductStoreDTO.class);
			
			return persistedStoreDTO;
			
		} catch (CartDataAccessException | NullPointerException
				| IllegalArgumentException|DuplicateKeyException exception) {
			
			logger.error("Failed to Persist Product Store. Reason - ",
					exception.getMessage(), exception);
			
			throw new CartServiceException();
			
		}
	}
}
