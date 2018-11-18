package de.fh.albsig.dardan.persistence;

import javax.persistence.EntityManagerFactory;

import de.fh.albsig.dardan.model.Rating;


public class RatingManager extends GenericManager<Integer, Rating>
{

	public RatingManager(final EntityManagerFactory factory)
	{
		super(factory);
	}

}
