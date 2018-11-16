package de.fh.albsig.dardan.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import de.fh.albsig.dardan.exception.NoSuchRowException;
import de.fh.albsig.dardan.model.OrderItem;


public final class OrderItemManager
{

	private final EntityManager manager;


	public OrderItemManager(final String persistenceUnitName)
	{
		final EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.manager = factory.createEntityManager();

		factory.close();
	}


	public List<OrderItem> listAll()
	{
		final TypedQuery<OrderItem> query = this.manager.createNamedQuery("OrderItem.listAll", OrderItem.class);
		return query.getResultList();
	}

	public OrderItem findByID(final int orderItemID)
			throws NoSuchRowException
	{
		final OrderItem orderItem = this.manager.find(OrderItem.class, orderItemID);
		if(orderItem == null)
			throw new NoSuchRowException();
		return orderItem;
	}

	public void save(final OrderItem orderItem)
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final OrderItem temp = this.manager.find(OrderItem.class, orderItem.getID());
		if(temp == null)
			this.manager.persist(orderItem);
		else
			this.manager.merge(orderItem);

		transaction.commit();
	}

	public void delete(final OrderItem orderItem)
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final OrderItem temp = this.manager.find(OrderItem.class, orderItem.getID());
		if(temp != null)
			this.manager.remove(orderItem);

		transaction.commit();
	}

	public void close()
	{
		if(this.manager != null)
			this.manager.close();
	}

}
