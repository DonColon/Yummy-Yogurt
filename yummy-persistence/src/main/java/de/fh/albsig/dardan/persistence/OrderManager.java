package de.fh.albsig.dardan.persistence;

import javax.persistence.EntityManagerFactory;

import de.fh.albsig.dardan.persistence.model.Order;


public class OrderManager extends GenericManager<Integer, Order>
{

	public OrderManager(final EntityManagerFactory factory)
	{
		super(factory);
	}

}
