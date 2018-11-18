package de.fh.albsig.dardan.persistence;

import javax.persistence.EntityManagerFactory;

import de.fh.albsig.dardan.model.OrderItem;


public class OrderItemManager extends GenericManager<Integer, OrderItem>
{

	public OrderItemManager(final EntityManagerFactory factory)
	{
		super(factory);
	}

}
