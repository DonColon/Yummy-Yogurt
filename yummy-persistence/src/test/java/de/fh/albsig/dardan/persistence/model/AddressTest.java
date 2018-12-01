package de.fh.albsig.dardan.persistence.model;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AddressTest
{

	@Test
	void testAddress()
	{
		final Address firstAddress = new Address("Bei der Schule", "12", "88515", "Langenenslingen");
		final Address secondAddress = new Address("Bei der Schule", "12", "88515", "Langenenslingen");
		final Address thirdAddress = new Address("Goethestraße", "8", "88499", "Riedlingen");
		final Address fourthAddress = null;

		assertEquals(firstAddress, secondAddress);
		assertEquals(firstAddress.hashCode(), firstAddress.hashCode());

		assertNotEquals(firstAddress, thirdAddress);
		assertNotEquals(firstAddress.hashCode(), thirdAddress.hashCode());

		assertNotEquals(firstAddress, fourthAddress);
	}

}
