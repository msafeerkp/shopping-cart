package org.spinach.cart.mapper;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.spinach.cart.bean.AccountBean;
import org.spinach.cart.domain.UserLogin;
import org.springframework.stereotype.Component;

/**
 * Map Party Account Creation bean to Party
 * @author Muhammed Safeer
 *
 */
@Component("customerAccountCreationMapper")
public class PartyMapper {
	
	@Resource
	DozerBeanMapper dtoMapper;
		
	public DozerBeanMapper getMapper() {
		return dtoMapper;
	}

	public void setMapper(DozerBeanMapper mapper) {
		this.dtoMapper = mapper;
	}

	/**
	 * Pull User Login information from Account Creation Bean.
	 * @param dto
	 * @return {@link Customer}
	 */
	public UserLogin getUserLogin(AccountBean account){
		UserLogin userLogin = dtoMapper.map(account,UserLogin.class);
		return userLogin; 
	}
}
