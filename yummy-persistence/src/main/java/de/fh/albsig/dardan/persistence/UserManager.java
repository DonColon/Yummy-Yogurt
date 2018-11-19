package de.fh.albsig.dardan.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import de.fh.albsig.dardan.model.User;


public class UserManager extends GenericManager<Integer, User>
{

	public UserManager(final EntityManagerFactory factory)
	{
		super(factory);
	}


	public User findByUsername(final String username)
	{
		final TypedQuery<User> query = this.manager.createNamedQuery("User.findByUsername", User.class);
		query.setParameter("username", username);
		return query.getSingleResult();
	}

	public User findByEmail(final String email)
	{
		final TypedQuery<User> query = this.manager.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

}
