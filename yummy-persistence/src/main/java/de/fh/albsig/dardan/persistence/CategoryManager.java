package de.fh.albsig.dardan.persistence;

import javax.persistence.EntityManagerFactory;

import de.fh.albsig.dardan.persistence.model.Category;


public class CategoryManager extends GenericManager<Integer, Category>
{

	public CategoryManager(final EntityManagerFactory factory)
	{
		super(factory);
	}

}
