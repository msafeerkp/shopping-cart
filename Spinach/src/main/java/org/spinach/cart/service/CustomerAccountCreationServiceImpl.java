package org.spinach.cart.service;

import javax.annotation.Resource;

import org.spinach.cart.domain.Customer;
import org.spinach.cart.dto.CustomerAccountCreationDTO;
import org.spinach.cart.mapper.CustomerAccountCreationMapper;

public class CustomerAccountCreationServiceImpl implements CustomerAccountCreationService{

	@Resource
	CustomerAccountCreationMapper customerAccountCreationMapper;
	
	public CustomerAccountCreationMapper getCustomerAccountCreationMapper() {
		return customerAccountCreationMapper;
	}

	public void setCustomerAccountCreationMapper(
			CustomerAccountCreationMapper customerAccountCreationMapper) {
		this.customerAccountCreationMapper = customerAccountCreationMapper;
	}

	/**
	 * Creates a Customer.
	 * @param dto
	 */
	@Override
	public void addCustomer(CustomerAccountCreationDTO dto) {
		Customer customer = customerAccountCreationMapper.getCustomerFromDto(dto);
		customer.addCustomer(customer);
		
	}
	
	
}
