package de.fh.albsig.dardan.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import de.fh.albsig.dardan.exception.NoSuchRowException;
import de.fh.albsig.dardan.model.Address;


public final class AddressManager
{

	private final EntityManager manager;


	public AddressManager(final String persistenceUnitName)
	{
		final EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.manager = factory.createEntityManager();

		factory.close();
	}


	public List<Address> listAll()
	{
		final TypedQuery<Address> query = this.manager.createNamedQuery("Address.listAll", Address.class);
		return query.getResultList();
	}

	public Address findByID(final int addressID)
			throws NoSuchRowException
	{
		final Address address = this.manager.find(Address.class, addressID);
		if(address == null)
			throw new NoSuchRowException();
		return address;
	}

	public void save(final Address address)
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final Address temp = this.manager.find(Address.class, address.getID());
		if(temp == null)
			this.manager.persist(address);
		else
			this.manager.merge(address);

		transaction.commit();
	}

	public void delete(final Address address)
			throws NoSuchRowException
	{
		final EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		final Address temp = this.manager.find(Address.class, address.getID());
		if(temp != null)
			this.manager.remove(address);

		transaction.commit();
	}

	public void close()
	{
		if(this.manager != null)
			this.manager.close();
	}

}
