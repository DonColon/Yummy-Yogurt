package de.fh.albsig.dardan.persistence;

import javax.persistence.EntityManagerFactory;

import de.fh.albsig.dardan.model.Yogurt;


public class YogurtManager extends GenericManager<Integer, Yogurt>
{

	public YogurtManager(final EntityManagerFactory factory)
	{
		super(factory);
	}

}
