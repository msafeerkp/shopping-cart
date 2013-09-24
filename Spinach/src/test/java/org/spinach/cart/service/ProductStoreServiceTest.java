package org.spinach.cart.service;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spinach.cart.data.repositories.ProductStoreRepository;
import org.spinach.cart.dto.AddressDTO;
import org.spinach.cart.dto.ProductStoreDTO;
import org.spinach.cart.exception.CartServiceException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test cases of Product Store Service.
 * 
 * @author safeer
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProductStoreServiceTest {

	@Inject
	ProductStoreService productStoreService;

	// remove repository once delete service implmented.
	@Inject
	ProductStoreRepository productStoreRepository;

	@Before
	public void setUp() {

		productStoreRepository.deleteAll();

		ProductStoreDTO productStoreDTO = new ProductStoreDTO();
		productStoreDTO.setName("Dummy Store1");
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddress("address");
		addressDTO.setCity("city");
		addressDTO.setCountry("country");
		addressDTO.setPhone("9999999");
		addressDTO.setPostalCode("000000");
		addressDTO.setState("state");
		productStoreDTO.setAddress(addressDTO);

		productStoreService.createProductStore(productStoreDTO);

	}

	@Test
	public void testCreateProductStoreService() {

		ProductStoreDTO productStoreDTO = new ProductStoreDTO();
		productStoreDTO.setName("Dummy Store2");
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddress("address");
		addressDTO.setCity("city");
		addressDTO.setCountry("country");
		addressDTO.setPhone("9999999");
		addressDTO.setPostalCode("000000");
		addressDTO.setState("state");
		productStoreDTO.setAddress(addressDTO);

		productStoreService.createProductStore(productStoreDTO);

	}

	@Test(expected = CartServiceException.class)
	public void testCreateProductStoreServiceWithNull() {

		ProductStoreDTO productStoreDTO = null;

		productStoreService.createProductStore(productStoreDTO);

	}

	@Test
	public void testUpdateProductStore() {

		ProductStoreDTO productStoreDTO = new ProductStoreDTO();
		productStoreDTO.setName("Dummy Store1");
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddress("address");
		addressDTO.setCity("city");
		addressDTO.setCountry("country");
		addressDTO.setPhone("9999999");
		addressDTO.setPostalCode("000000");
		addressDTO.setState("state");
		productStoreDTO.setAddress(addressDTO);

		productStoreService.updateProductStore(productStoreDTO);

	}

}
