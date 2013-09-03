package org.spinach.cart.data.entities;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spinach.cart.data.entities.ProductStore;
import org.spinach.cart.data.repositories.ProductStoreRepository;
import org.spinach.cart.data.vo.Address;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProductStoreTest {

	@Inject
	public ProductStoreRepository productStoreRepository;
	
	@Test
	public void create(){
		ProductStore store = new ProductStore();
		store.setName("Dummy Store");
		Address address = new Address();
		address.setAddress("BTM Layout");
		address.setCity("Bangalore");
		address.setPhone("1234567890");
		address.setPostalCode("670566");
		address.setState("Karnataka");
		store.setAddress(address);
		productStoreRepository.save(store);
	}
}
