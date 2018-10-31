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
	}
	
	
	public List<Ingredient> listAll() 
	{
		final TypedQuery<Ingredient> query = manager.createNamedQuery("Ingredient.listAll", Ingredient.class);
		return query.getResultList();
	}
	
	public Ingredient findByID(final int ingredientID) 
			throws NoSuchRowException 
	{
		final Ingredient ingredient = manager.find(Ingredient.class, ingredientID);
		if(ingredient == null)
			throw new NoSuchRowException();
		return ingredient;
	}
	
	public Ingredient findByName(final String ingredientname) 
			throws NoSuchRowException 
	{
		final TypedQuery<Ingredient> query = manager.createNamedQuery("Ingredient.findByName", Ingredient.class);
		query.setParameter("name", ingredientname);
		
		final Ingredient ingredient = query.getSingleResult();
		
		if(ingredient == null)
			throw new NoSuchRowException();
		return ingredient;
	}
	
	public void save(final Ingredient ingredient) 
	{
		final EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			final Ingredient temp = manager.find(Ingredient.class, ingredient.getID());
			if(temp == null)
				manager.persist(ingredient);
			else
				manager.merge(ingredient);
		transaction.commit();
	}
	
	public void delete(final Ingredient ingredient) 
			throws NoSuchRowException 
	{
		final EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			final Ingredient temp = this.findByID(ingredient.getID());
			if(temp != null)
				manager.remove(ingredient);
		transaction.commit();
	}
	
	public void close() 
	{
		if(manager != null)
			manager.close();
	}
	
}
