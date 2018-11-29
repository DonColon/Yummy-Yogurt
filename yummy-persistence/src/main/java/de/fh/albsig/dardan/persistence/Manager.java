package de.fh.albsig.dardan.persistence;

import java.util.List;

import de.fh.albsig.dardan.persistence.exception.DatabaseException;
import de.fh.albsig.dardan.persistence.model.Identifiable;


public interface Manager<K, E extends Identifiable<K>>
{

	List<E> listAll();

	E findByID(K primaryKey) throws DatabaseException.NoSuchRow;

	void save(E entity);

	void update(E entity) throws DatabaseException.NoSuchRow;

	void delete(E entity) throws DatabaseException.NoSuchRow;

	void close();

}
