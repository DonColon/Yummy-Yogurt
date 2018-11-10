package de.fh.albsig.dardan.persist;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import de.fh.albsig.dardan.exception.NoSuchRowException;
import de.fh.albsig.dardan.model.Ingredient;


public final class IngredientManager
{

	private final EntityManager manager;


	public IngredientManager(final String persistenceUnitName)
	{
		final EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.manager = factory.createEntityManager();

		factory.close();
	}


	public List<Ingredient> listAll()
	{
		final TypedQuery<Ingredient> query = this.manager.createNamedQuery("Ingredient.listAll", Ingredient.class);
		return query.getResultList();
	}

	public Ingredient findByID(final int ingredientID)
			throws NoSuchRowException
	{
		final Ingredient ingredient = this.manager.find(Ingredient.class, ingredientID);
		if(ingredient == null)
			throw new NoSuchRowException();
		return ingredient;
	}

	public Ingredient findByName(final String ingredientname)
			throws NoSuchRowException
	{
		final TypedQuery<Ingredient> query = this.manager.createNamedQuery("Ingredient.findByName", Ingredient.class);
		query.setParameter("name", ingredientname);

		final Ingredient ingredient = query.getSingleResult();

		if(ingredient == null)
			throw new NoSuchRowException();
		return ingredient;
	}

	public void save(final Ingredient ingredient)
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final Ingredient temp = this.manager.find(Ingredient.class, ingredient.getID());
		if(temp == null)
			this.manager.persist(ingredient);
		else
			this.manager.merge(ingredient);

		transaction.commit();
	}

	public void delete(final Ingredient ingredient)
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final Ingredient temp = this.manager.find(Ingredient.class, ingredient.getID());
		if(temp != null)
			this.manager.remove(ingredient);

		transaction.commit();
	}

	public void close()
	{
		if(this.manager != null)
			this.manager.close();
	}

}
