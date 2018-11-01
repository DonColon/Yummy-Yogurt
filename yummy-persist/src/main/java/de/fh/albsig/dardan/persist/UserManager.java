package de.fh.albsig.dardan.persist;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import de.fh.albsig.dardan.exception.NoSuchRowException;
import de.fh.albsig.dardan.model.User;
import de.fh.albsig.dardan.model.Yogurt;


public final class UserManager 
{
	
	private final EntityManager manager;
	
	
	public UserManager(final String persistenceUnitName) 
	{
		final EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.manager = factory.createEntityManager();
		
		factory.close();
	}
	
	
	public List<User> listAll() 
	{
		final TypedQuery<User> query = manager.createNamedQuery("User.listAll", User.class);
		return query.getResultList();
	}
	
	public User findByID(final int userID) 
			throws NoSuchRowException 
	{
		final User user = manager.find(User.class, userID);
		if(user == null)
			throw new NoSuchRowException();
		return user;
	}
	
	public User findByUsername(final String username) 
			throws NoSuchRowException 
	{
		final TypedQuery<User> query = manager.createNamedQuery("User.findByUsername", User.class);
		query.setParameter("username", username);
		
		final User user = query.getSingleResult();
		
		if(user == null)
			throw new NoSuchRowException();
		return user;
	}
	
	public List<Yogurt> fetchYogurtsOfUser(final int userID) 
			throws NoSuchRowException
	{
		final TypedQuery<Yogurt> query = manager.createQuery("select yogurt from Yogurt yogurt where yogurt.owner.userID = :userID", Yogurt.class);
		query.setParameter("userID", userID);
		
		return query.getResultList();
	}
	
	public void save(final User user) 
	{
		final EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			final User temp = manager.find(User.class, user.getID());
			if(temp == null)
				manager.persist(user);
			else
				manager.merge(user);
		transaction.commit();
	}
	
	public void delete(final User user) 
			throws NoSuchRowException 
	{
		final EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			final User temp = this.findByID(user.getID());
			if(temp != null)
				manager.remove(user);
		transaction.commit();
	}
	
	public void close() 
	{
		if(manager != null)
			manager.close();
	}

}

