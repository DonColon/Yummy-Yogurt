package de.fh.albsig.dardan.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import de.fh.albsig.dardan.model.Yogurt;


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

	public Yogurt findByName(final String yogurtname)
	{
		final TypedQuery<Yogurt> query = this.manager.createNamedQuery(
				"Yogurt.findByName", this.entityClass);

		query.setParameter("yogurtname", yogurtname);

		return query.getSingleResult();
	}

	public Yogurt findByUser(final String username)
	{
		final TypedQuery<Yogurt> query = this.manager.createNamedQuery(
				"Yogurt.findByUser", this.entityClass);

		query.setParameter("username", username);

		return query.getSingleResult();
	}

}
