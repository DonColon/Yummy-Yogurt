package de.fh.albsig.dardan.persistence;

import javax.persistence.EntityManagerFactory;

import de.fh.albsig.dardan.model.User;


public class UserManager extends GenericManager<Integer, User>
{

	public UserManager(final EntityManagerFactory factory)
	{
		super(factory);
	}

}
