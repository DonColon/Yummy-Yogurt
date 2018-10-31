package de.fh.albsig.dardan.persist;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import de.fh.albsig.dardan.exception.NoSuchRowException;
import de.fh.albsig.dardan.model.Category;


public final class CategoryManager 
{
	
	private final EntityManager manager;
	
	
	public CategoryManager(final String persistenceUnitName) 
	{
		final EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.manager = factory.createEntityManager();
	}
	
	
	public List<Category> listAll() 
	{
		final TypedQuery<Category> query = manager.createNamedQuery("Category.listAll", Category.class);
		return query.getResultList();
	}
	
	public Category findByID(final int categoryID) 
			throws NoSuchRowException 
	{
		final Category category = manager.find(Category.class, categoryID);
		if(category == null)
			throw new NoSuchRowException();
		return category;
	}
	
	public void save(final Category category) 
	{
		final EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			final Category temp = manager.find(Category.class, category.getID());
			if(temp == null)
				manager.persist(category);
			else
				manager.merge(category);
		transaction.commit();
	}
	
	public void delete(final Category category) 
			throws NoSuchRowException 
	{
		final EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			final Category temp = this.findByID(category.getID());
			if(temp != null)
				manager.remove(category);
		transaction.commit();
	}
	
	public void close() 
	{
		if(manager != null)
			manager.close();
	}
	
}
