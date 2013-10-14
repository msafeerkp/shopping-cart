package org.spinach.cart.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spinach.cart.data.entities.ProductStoreEntity;
import org.spinach.cart.data.repositories.ProductStoreRepository;
import org.spinach.cart.dto.AddressDTO;
import org.spinach.cart.dto.ProductStoreDTO;
import org.spinach.cart.exception.CartDataAccessException;
import org.spinach.cart.exception.CartServiceException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Named("productStoreService")
public class ProductStoreService {

	Logger logger = LoggerFactory.getLogger(ProductStoreService.class);

	@Inject
	ProductStoreRepository productStoreRepository;

	@Inject
	ModelMapper mapper;

	/**
	 * Create a Product Store with given details.
	 * 
	 * @param productStoreDTO
	 * @throws CartServiceException
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public ProductStoreDTO createProductStore(ProductStoreDTO productStoreDTO)
			throws CartServiceException {
		try {

			ProductStoreEntity productStoreEntity = mapper.map(productStoreDTO,
					ProductStoreEntity.class);

			ProductStoreEntity persistedStoreEntity = productStoreRepository
					.save(productStoreEntity);

			ProductStoreDTO persistedStoreDTO = mapper.map(
					persistedStoreEntity, ProductStoreDTO.class);

			logger.info("Product Store entity is created - "
					+ persistedStoreDTO.toString());

			return persistedStoreDTO;

		} catch (CartDataAccessException | NullPointerException
				| IllegalArgumentException | DuplicateKeyException exception) {

			logger.error("Failed to Persist Product Store. Reason - ",
					exception.getMessage(), exception);

			throw new CartServiceException();

		}
	}
	
	/**
	 * Copy Ids from {@link ProductStoreEntity} to {@link ProductStoreDTO}
	 * @param productStoreDTO
	 * @param productStoreEntity
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public ProductStoreDTO updateStoreIds(ProductStoreDTO productStoreDTO, ProductStoreEntity productStoreEntity){
		String productStoreId = productStoreEntity.getProductStoreId();
		String addressId = productStoreEntity.getAddress().getAddressId();
		
		AddressDTO addressDTO = productStoreDTO.getAddress();
		addressDTO.setAddressId(addressId);
		
		productStoreDTO.setProductStoreid(productStoreId);
		productStoreDTO.setAddress(addressDTO);
		return productStoreDTO;
	}
	
	/**
	 * Update Product Store with given details
	 * 
	 * @param productStoreDTO
	 * 
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public ProductStoreDTO updateProductStore(ProductStoreDTO productStoreDTO) {

		ProductStoreEntity productStoreEntity = null;
		ProductStoreDTO updatedStoreDTO = null;

		try {

			productStoreEntity = productStoreRepository
					.findByName(productStoreDTO.getProductStoreName());
			
			productStoreDTO = updateStoreIds(productStoreDTO, productStoreEntity);
			

			logger.debug("Product Store found - "
					+ productStoreEntity.toString());

			productStoreEntity = mapper.map(productStoreDTO,
					ProductStoreEntity.class);

			productStoreEntity = productStoreRepository
					.save(productStoreEntity);

			updatedStoreDTO = mapper.map(productStoreEntity,
					ProductStoreDTO.class);

			logger.info("Product Store updated - " + updatedStoreDTO.toString());

		} catch (CartDataAccessException | NullPointerException
				| IllegalArgumentException | DuplicateKeyException exception) {

			logger.error("Failed to update Product Store. Reason - ",
					exception.getMessage(), exception);
			throw new CartServiceException();

		}

		return updatedStoreDTO;

	}
}
