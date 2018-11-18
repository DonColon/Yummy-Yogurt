package de.fh.albsig.dardan.persistence;

import java.util.List;

import de.fh.albsig.dardan.exception.NoSuchRowException;
import de.fh.albsig.dardan.model.Identifiable;

public interface Manager<K, E extends Identifiable<K>>
{

	List<E> listAll();
	E findByID(K primaryKey) throws NoSuchRowException;

	void save(E entity);
	void delete(E entity) throws NoSuchRowException;
	void close();

}
