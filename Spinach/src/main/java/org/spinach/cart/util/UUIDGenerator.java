package org.spinach.cart.util;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Manages the uuid generation and Conversion.
 * 
 * @author Muhammed Safeer
 * 
 */
public final class UUIDGenerator {
	
	/**
	 * Creates random uuid using using Java UUID.
	 * 
	 * @return {@link String}
	 * @see {@link UUID}
	 */
	public static String getuuid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * Converts uuid from UUID to byte.
	 * @param uuid
	 * @return {@link byte}
	 * @see byte,UUID
	 */
	public static byte[] uuidTobyte(UUID uuid) {
		ByteBuffer buffer = ByteBuffer.allocate(16);
		buffer.putLong(uuid.getMostSignificantBits());
		buffer.putLong(uuid.getLeastSignificantBits());
		return buffer.array();
	}

	/**
	 * Converts uuid from byte to UUID.
	 * @param uuidInbyte
	 * @return
	 * @see byte,UUID
	 */
	public static UUID byteTouuid(byte[] uuidInbyte) {
		ByteBuffer buffer = ByteBuffer.wrap(uuidInbyte);
		UUID uuid = new UUID(buffer.getLong(), buffer.getLong());
		return uuid;
	}
}
