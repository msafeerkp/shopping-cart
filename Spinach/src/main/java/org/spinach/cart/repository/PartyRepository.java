package org.spinach.cart.repository;

import org.spinach.cart.domain.Party;
import org.springframework.data.repository.CrudRepository;

/**
 * The Repository class for the Party.
 * @author Muhammed Safeer
 *
 */
public interface PartyRepository extends CrudRepository<Party, String>{}
