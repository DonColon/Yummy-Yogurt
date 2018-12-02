package de.fh.albsig.dardan.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import de.fh.albsig.dardan.persistence.exception.DatabaseException;
import de.fh.albsig.dardan.persistence.model.Yogurt;


public class YogurtManager extends GenericManager<Integer, Yogurt>
{

	public YogurtManager(final EntityManagerFactory factory)
	{
		super(factory);
	}


	public List<Yogurt> listIfVisible()
	{
		final TypedQuery<Yogurt> query = this.manager.createNamedQuery(
				"Yogurt.listIfVisible", this.entityClass);

		return query.getResultList();
	}

	public List<Yogurt> listByPriceAsc()
	{
		final TypedQuery<Yogurt> query = this.manager.createNamedQuery(
				"Yogurt.listByPriceAsc", this.entityClass);

		return query.getResultList();
	}

	public List<Yogurt> listByPriceDesc()
	{
		final TypedQuery<Yogurt> query = this.manager.createNamedQuery(
				"Yogurt.listByPriceDesc", this.entityClass);

		return query.getResultList();
	}

	public List<Yogurt> listByNameAsc()
	{
		final TypedQuery<Yogurt> query = this.manager.createNamedQuery(
				"Yogurt.listByNameAsc", this.entityClass);
		return query.getResultList();
	}

	public List<Yogurt> listByNameDesc()
	{
		final TypedQuery<Yogurt> query = this.manager.createNamedQuery(
				"Yogurt.listByNameDesc", this.entityClass);
		return query.getResultList();
	}

	public List<Yogurt> listByOwner(final String username)
	{
		final TypedQuery<Yogurt> query = this.manager.createNamedQuery(
				"Yogurt.listByOwner", this.entityClass);
		query.setParameter("username", username);
		return query.getResultList();
	}

	public Yogurt findByName(final String name)
		throws DatabaseException.NoSuchRow, DatabaseException.TooManyRows
	{
		final TypedQuery<Yogurt> query = this.manager.createNamedQuery(
				"Yogurt.findByName", this.entityClass);
		query.setParameter("yogurtname", name);
		Yogurt yogurt = new Yogurt();

		try {
			yogurt = query.getSingleResult();

		} catch(final NoResultException e) {
			throw new DatabaseException.NoSuchRow("There is no such row for the name: " + name, e);

		} catch(final NonUniqueResultException e) {
			throw new DatabaseException.TooManyRows("No unique result for the name: " + name, e);
		}

		return yogurt;
	}

}
