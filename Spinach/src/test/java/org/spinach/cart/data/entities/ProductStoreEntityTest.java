package org.spinach.cart.data.entities;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spinach.cart.data.entities.ProductStoreEntity;
import org.spinach.cart.data.repositories.ProductStoreRepository;
import org.spinach.cart.data.vo.AddressVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Include all test case related to Product Store entity.
 * @author safeer
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProductStoreEntityTest {

	@Inject
	public ProductStoreRepository productStoreRepository;
	
	/**
	 * create a Product Store Entity.
	 */
	@Test
	public void testCreateProdcutStoreEntity(){
		ProductStoreEntity store = new ProductStoreEntity();
		store.setName("Dummy Store2");
		AddressVO address = new AddressVO();
		address.setAddress("BTM Layout");
		address.setCity("Bangalore");
		address.setPhone("1234567890");
		address.setPostalCode("670566");
		address.setState("Karnataka");
		store.setAddress(address);
		productStoreRepository.save(store);
	}
	/**
	 * create a Product Store Entity With Null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCreateProdcutStoreEntityWithNull(){
		ProductStoreEntity store = null;
		productStoreRepository.save(store);
	}
}
