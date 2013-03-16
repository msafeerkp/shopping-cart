package org.spinach.cart.repository;

import org.spinach.cart.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author msafeerkp
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {}
