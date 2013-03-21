package org.spinach.cart.dto;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @author Muhammed Safeer
 * 
 */
public abstract class BaseDTO {
	/**
	 * Method to get a String representing the current state of the DTO.
	 * 
	 * @return string of fields listed in the DTO
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);

	}
}
