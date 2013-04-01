package org.spinach.cart.repository;

import org.spinach.cart.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * The repository class for the Person.
 * @author msafeerkp
 *
 */
public interface PersonRepository extends CrudRepository<Person, String> {}
