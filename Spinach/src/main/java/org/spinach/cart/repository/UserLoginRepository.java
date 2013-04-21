package org.spinach.cart.repository;

import org.spinach.cart.domain.UserLogin;
import org.springframework.data.repository.CrudRepository;

/**
 * The Repository class for the User Login
 * @author Muhammed Safeer
 *
 */
public interface UserLoginRepository extends CrudRepository<UserLogin, String>{
	UserLogin findByUserIdAndEnabled(String userId,String enabled);
}
