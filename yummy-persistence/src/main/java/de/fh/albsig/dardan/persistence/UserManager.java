package de.fh.albsig.dardan.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import de.fh.albsig.dardan.persistence.exception.DatabaseException;
import de.fh.albsig.dardan.persistence.model.User;


public class UserManager extends GenericManager<Integer, User>
{

	public UserManager(final EntityManagerFactory factory)
	{
		super(factory);
	}


	public User findByUsername(final String username)
		throws DatabaseException.NoSuchRow, DatabaseException.TooManyRows
	{
		final TypedQuery<User> query = this.manager.createNamedQuery("User.findByUsername", User.class);
		query.setParameter("username", username);
		User user = new User();

		try {
			user = query.getSingleResult();

		} catch(final NoResultException e) {
			throw new DatabaseException.NoSuchRow("There is no such row for the username: " + username, e);

		} catch(final NonUniqueResultException e) {
			throw new DatabaseException.TooManyRows("No unique result for the username: " + username, e);
		}

		return user;
	}

	public User findByEmail(final String email)
		throws DatabaseException.NoSuchRow, DatabaseException.TooManyRows
	{
		final TypedQuery<User> query = this.manager.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("email", email);
		User user = new User();

		try {
			user = query.getSingleResult();

		} catch(final NoResultException e) {
			throw new DatabaseException.NoSuchRow("There is no such row for the email: " + email, e);

		} catch(final NonUniqueResultException e) {
			throw new DatabaseException.TooManyRows("No unique result for the email: " + email, e);
		}

		return user;
	}

}
