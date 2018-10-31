package de.fh.albsig.dardan.persist;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import de.fh.albsig.dardan.exception.NoSuchRowException;
import de.fh.albsig.dardan.model.OrderItem;
import de.fh.albsig.dardan.model.OrderItemID;


public final class OrderItemManager 
{

	private final EntityManager manager;
	
	
	public OrderItemManager(final String persistenceUnitName) 
	{
		final EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.manager = factory.createEntityManager();
	}
	
	
	public List<OrderItem> listAll() 
	{
		final TypedQuery<OrderItem> query = manager.createNamedQuery("OrderItem.listAll", OrderItem.class);
		return query.getResultList();
	}
	
	public OrderItem findByID(final OrderItemID orderItemID) 
			throws NoSuchRowException 
	{
		final OrderItem orderItem = manager.find(OrderItem.class, orderItemID);
		if(orderItem == null)
			throw new NoSuchRowException();
		return orderItem;
	}
	
	public void save(final OrderItem orderItem) 
	{
		final EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			final OrderItem temp = manager.find(OrderItem.class, orderItem.getID());
			if(temp == null)
				manager.persist(orderItem);
			else
				manager.merge(orderItem);
		transaction.commit();
	}
	
	public void delete(final OrderItem orderItem) 
			throws NoSuchRowException 
	{
		final EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			final OrderItem temp = this.findByID(orderItem.getID());
			if(temp != null)
				manager.remove(orderItem);
		transaction.commit();
	}
	
	public void close() 
	{
		if(manager != null)
			manager.close();
	}
	
}
