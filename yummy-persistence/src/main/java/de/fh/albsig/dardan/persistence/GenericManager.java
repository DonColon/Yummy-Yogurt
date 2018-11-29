package de.fh.albsig.dardan.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import de.fh.albsig.dardan.persistence.exception.DatabaseException;
import de.fh.albsig.dardan.persistence.model.Identifiable;


public abstract class GenericManager<K, E extends Identifiable<K>> implements Manager<K, E>
{

	protected final EntityManager manager;
	protected final Class<E> entityClass;


	@SuppressWarnings("unchecked")
	public GenericManager(final EntityManagerFactory factory)
	{
		this.manager = factory.createEntityManager();

		final ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();

		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
	}


	@Override
	public final List<E> listAll()
	{
		final String queryName = String.format("%s.listAll", this.entityClass.getSimpleName());
		final TypedQuery<E> query = this.manager.createNamedQuery(queryName, this.entityClass);
		return query.getResultList();
	}

	@Override
	public final E findByID(final K primaryKey)
		throws DatabaseException.NoSuchRow
	{
		final E entity = this.manager.find(this.entityClass, primaryKey);
		if(entity == null)
			throw new DatabaseException.NoSuchRow("There is no such row for the id: " + primaryKey);
		return entity;
	}

	@Override
	public final void save(final E entity)
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final E temp = this.manager.find(this.entityClass, entity.getID());

		if(temp == null)
			this.manager.persist(entity);

		transaction.commit();
	}

	@Override
	public void update(final E entity)
		throws DatabaseException.NoSuchRow
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final E temp = this.manager.find(this.entityClass, entity.getID());
		if(temp != null)
			this.manager.merge(entity);
		else
			throw new DatabaseException.NoSuchRow("There is no such row for the id: " + entity.getID());

		transaction.commit();
	}

	@Override
	public final void delete(final E entity)
		throws DatabaseException.NoSuchRow
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final E temp = this.manager.find(this.entityClass, entity.getID());
		if(temp != null)
			this.manager.remove(entity);
		else
			throw new DatabaseException.NoSuchRow("There is no such row for the id: " + entity.getID());

		transaction.commit();
	}

	@Override
	public final void close()
	{
		if(this.manager != null)
			this.manager.close();
	}

}
