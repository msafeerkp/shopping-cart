package org.spinach.cart.util;

import java.util.UUID;

public final class UUIDGenerator {
	/**
	 *  generates UUID
	 * @return
	 */
	public static String generate(){
		return UUID.randomUUID().toString();
	}
	
}
