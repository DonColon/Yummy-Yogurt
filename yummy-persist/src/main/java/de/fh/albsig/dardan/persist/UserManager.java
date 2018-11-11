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
		final TypedQuery<User> query = this.manager.createNamedQuery("User.listAll", User.class);
		return query.getResultList();
	}

	public User findByID(final int userID)
			throws NoSuchRowException
	{
		final User user = this.manager.find(User.class, userID);
		if(user == null)
			throw new NoSuchRowException();
		return user;
	}

	public User findByUsername(final String username)
			throws NoSuchRowException
	{
		final TypedQuery<User> query = this.manager.createNamedQuery("User.findByUsername", User.class);
		query.setParameter("username", username);

		final User user = query.getSingleResult();

		if(user == null)
			throw new NoSuchRowException();
		return user;
	}

	public List<Yogurt> fetchYogurtsOfUser(final int userID)
			throws NoSuchRowException
	{
		final TypedQuery<Yogurt> query = this.manager.createNamedQuery("Yogurt.findByOwner", Yogurt.class);
		query.setParameter("userID", userID);

		return query.getResultList();
	}

	public void save(final User user)
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final User temp = this.manager.find(User.class, user.getID());
		if(temp == null)
			this.manager.persist(user);
		else
			this.manager.merge(user);

		transaction.commit();
	}

	public void delete(final User user)
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final User temp = this.manager.find(User.class, user.getID());
		if(temp != null)
			this.manager.remove(user);

		transaction.commit();
	}

	public void close()
	{
		if(this.manager != null)
			this.manager.close();
	}

}

