package de.fh.albsig.dardan.persist;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import de.fh.albsig.dardan.exception.NoSuchRowException;
import de.fh.albsig.dardan.model.Order;


public final class OrderManager
{

	private final EntityManager manager;


	public OrderManager(final String persistenceUnitName)
	{
		final EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.manager = factory.createEntityManager();

		factory.close();
	}


	public List<Order> listAll()
	{
		final TypedQuery<Order> query = this.manager.createNamedQuery("Order.listAll", Order.class);
		return query.getResultList();
	}

	public Order findByID(final int orderID)
			throws NoSuchRowException
	{
		final Order order = this.manager.find(Order.class, orderID);
		if(order == null)
			throw new NoSuchRowException();
		return order;
	}

	public void save(final Order order)
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final Order temp = this.manager.find(Order.class, order.getID());
		if(temp == null)
			this.manager.persist(order);
		else
			this.manager.merge(order);

		transaction.commit();
	}

	public void delete(final Order order)
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final Order temp = this.manager.find(Order.class, order.getID());
		if(temp != null)
			this.manager.remove(order);

		transaction.commit();
	}

	public void close()
	{
		if(this.manager != null)
			this.manager.close();
	}

}
