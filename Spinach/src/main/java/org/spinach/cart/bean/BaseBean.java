package org.spinach.cart.bean;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BaseBean {
	/**
	 * Method to get a String representing the current state of the Managed Bean.
	 * 
	 * @return string of fields listed in the DTO
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);

	}
}
