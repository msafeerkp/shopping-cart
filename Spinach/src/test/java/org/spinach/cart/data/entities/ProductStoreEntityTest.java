package org.spinach.cart.data.entities;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spinach.cart.data.entities.ProductStoreEntity;
import org.spinach.cart.data.repositories.ProductStoreRepository;
import org.spinach.cart.data.vo.AddressVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test cases of Product Store entity.
 * 
 * @author safeer
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProductStoreEntityTest {

	@Inject
	public ProductStoreRepository productStoreRepository;

	@Before
	public void setUp() {

		productStoreRepository.deleteAll();

		ProductStoreEntity store = new ProductStoreEntity();
		store.setName("Dummy Store1");
		AddressVO address = new AddressVO();
		address.setAddress("address");
		address.setCity("city");
		address.setPhone("99999999");
		address.setPostalCode("666666");
		address.setState("state");
		address.setCountry("country");
		store.setAddress(address);
		productStoreRepository.save(store);

	}

	@Test
	public void testCreateProdcutStoreEntity() {

		ProductStoreEntity store = new ProductStoreEntity();
		store.setName("Dummy Store2");
		AddressVO address = new AddressVO();
		address.setAddress("address");
		address.setCity("city");
		address.setPhone("99999999");
		address.setPostalCode("666666");
		address.setState("state");
		address.setCountry("country");
		store.setAddress(address);
		productStoreRepository.save(store);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateProdcutStoreEntityWithNull() {
		ProductStoreEntity store = null;
		productStoreRepository.save(store);
	}

	@Test
	public void updateProductStoreEntity() {

		ProductStoreEntity productStoreEntity = productStoreRepository
				.findByName("Dummy Store1");
		AddressVO address = new AddressVO();
		address.setAddress("update address");
		address.setCity("updated city");
		address.setPhone("99999999");
		address.setPostalCode("666666");
		address.setState("updated state");
		address.setCountry("updated country");
		productStoreEntity.setAddress(address);
		productStoreRepository.save(productStoreEntity);

	}
}
