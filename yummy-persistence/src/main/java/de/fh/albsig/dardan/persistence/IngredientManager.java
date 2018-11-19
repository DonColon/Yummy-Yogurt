package de.fh.albsig.dardan.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import de.fh.albsig.dardan.model.Ingredient;


public class IngredientManager extends GenericManager<Integer, Ingredient>
{

	public IngredientManager(final EntityManagerFactory factory)
	{
		super(factory);
	}


	public List<Ingredient> findByCategory(final String categoryname)
	{
		final TypedQuery<Ingredient> query = this.manager.createNamedQuery("Ingredient.findByCategory", Ingredient.class);
		query.setParameter("categoryname", categoryname);
		return query.getResultList();
	}

}
