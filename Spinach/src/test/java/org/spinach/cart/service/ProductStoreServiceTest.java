package org.spinach.cart.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spinach.cart.dto.AddressDTO;
import org.spinach.cart.dto.ProductStoreDTO;
import org.spinach.cart.exception.CartServiceException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Include all test case related to Product Store Service.
 * @author safeer
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProductStoreServiceTest {

	@Inject
	ProductStoreService productStoreService;
	
	/**
	 * Test create Product Store Service.
	 */
	@Test
	public void testCreateProductStoreService(){
		ProductStoreDTO productStoreDTO = new ProductStoreDTO();
		productStoreDTO.setName("Dummy Store2");
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddress("Pappinisseri");
		addressDTO.setCity("Kannur");
		addressDTO.setCountry("India");
		addressDTO.setPhone("1234567891");
		addressDTO.setPostalCode("670561");
		addressDTO.setState("kerala");
		productStoreDTO.setAddress(addressDTO);
		productStoreService.createProductStore(productStoreDTO);
	}
	
	/**
	 * Test create Product Store Service with Null argument.
	 */
	@Test(expected=CartServiceException.class)
	public void testCreateProductStoreServiceWithNull(){
		ProductStoreDTO productStoreDTO = null;
		productStoreService.createProductStore(productStoreDTO);
	}
	
}
