package org.spinach.cart.repository;

import org.spinach.cart.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author msafeerkp
 *
 */
public interface PersonRepository extends CrudRepository<Person, Long> {}
