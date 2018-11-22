package de.fh.albsig.dardan.persistence.model;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.fh.albsig.dardan.persistence.model.Address;

class AddressTest 
{
	
	@Test
	void test() 
	{
		final Address firstAddress = new Address("Bei der Schule", "12", "88515", "Langenenslingen");
		final Address secondAddress = new Address("Bei der Schule", "12", "88515", "Langenenslingen");
		final Address thirdAddress = new Address("Goethestra�e", "8", "88499", "Riedlingen");
		
		assertTrue(firstAddress.equals(secondAddress));
		assertEquals(firstAddress.hashCode(), firstAddress.hashCode());
		
		assertFalse(firstAddress.equals(thirdAddress));
		assertNotEquals(firstAddress.hashCode(), thirdAddress.hashCode());
	}

}
