package de.fh.albsig.dardan.persistence;

import javax.persistence.EntityManagerFactory;

import de.fh.albsig.dardan.persistence.model.Address;


public class AddressManager extends GenericManager<Integer, Address>
{

	public AddressManager(final EntityManagerFactory factory)
	{
		super(factory);
	}

}
