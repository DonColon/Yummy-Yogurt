package de.fh.albsig.dardan.persistence;

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

		factory.close();
	}


	public List<Category> listAll()
	{
		final TypedQuery<Category> query = this.manager.createNamedQuery("Category.listAll", Category.class);
		return query.getResultList();
	}

	public Category findByID(final int categoryID)
			throws NoSuchRowException
	{
		final Category category = this.manager.find(Category.class, categoryID);
		if(category == null)
			throw new NoSuchRowException();
		return category;
	}

	public void save(final Category category)
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final Category temp = this.manager.find(Category.class, category.getID());
		if(temp == null)
			this.manager.persist(category);
		else
			this.manager.merge(category);

		transaction.commit();
	}

	public void delete(final Category category)
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final Category temp = this.manager.find(Category.class, category.getID());
		if(temp != null)
			this.manager.remove(category);

		transaction.commit();
	}

	public void close()
	{
		if(this.manager != null)
			this.manager.close();
	}

}
