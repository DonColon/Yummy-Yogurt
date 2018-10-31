package de.fh.albsig.dardan.persist;

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
	}
	
	
	public List<Address> listAll() 
	{
		final TypedQuery<Address> query = manager.createNamedQuery("Address.listAll", Address.class);
		return query.getResultList();
	}
	
	public Address findByID(final int addressID) throws NoSuchRowException 
	{
		final Address address = manager.find(Address.class, addressID);
		if(address == null)
			throw new NoSuchRowException();
		return address;
	}
	
	public void save(final Address address) 
	{
		final EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			final Address temp = manager.find(Address.class, address.getID());
			if(temp == null)
				manager.persist(address);
			else
				manager.merge(address);
		transaction.commit();
	}
	
	public void delete(final Address address) throws NoSuchRowException
	{
		final EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			final Address temp = this.findByID(address.getID());
			if(temp != null)
				manager.remove(address);
		transaction.commit();
	}
	
	public void close() 
	{
		if(manager != null)
			manager.close();
	}

}
