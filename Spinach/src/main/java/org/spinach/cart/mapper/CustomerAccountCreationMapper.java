package org.spinach.cart.mapper;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.spinach.cart.dto.CustomerAccountCreationDTO;
import org.springframework.stereotype.Component;

/**
 * Map Customer Account Creation DTO to Customer
 * @author Muhammed Safeer
 *
 */
@Component("customerAccountCreationMapper")
public class CustomerAccountCreationMapper {
	
	@Resource
	DozerBeanMapper dtoMapper;
		
	public DozerBeanMapper getMapper() {
		return dtoMapper;
	}

	public void setMapper(DozerBeanMapper mapper) {
		this.dtoMapper = mapper;
	}

	/**
	 * Pull customer information from Account Creation DTO.
	 * @param dto
	 * @return {@link Customer}
	 */
/*	public Customer getCustomerFromDto(CustomerAccountCreationDTO dto){
		Customer customer = dtoMapper.map(dto,Customer.class);
		return customer; 
	}
*/}
