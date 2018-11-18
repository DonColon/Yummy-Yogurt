package de.fh.albsig.dardan.persistence;

import javax.persistence.EntityManagerFactory;

import de.fh.albsig.dardan.model.Ingredient;


public class IngredientManager extends GenericManager<Integer, Ingredient>
{

	public IngredientManager(final EntityManagerFactory factory)
	{
		super(factory);
	}

}
