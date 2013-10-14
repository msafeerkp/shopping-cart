package org.spinach.cart.data.repositories;

import java.io.Serializable;

public interface GenericRepository<T,ID extends Serializable> extends Repository<T, ID>{
	
	/**
	 * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
	 * entity instance completely.
	 * 
	 * @param entity
	 * @return the saved entity
	 */
	<S extends T> S save(S entity);
	
	/**
	 * Returns all instances of the type.
	 * 
	 * @return all entities
	 */
	Iterable<T> findAll();
	
	/**
	 * Deletes the entity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
	 */
	void delete(ID id);
	
	/**
	 * Deletes a given entity.
	 * 
	 * @param entity
	 * @throws IllegalArgumentException in case the given entity is (@literal null}.
	 */
	void delete(T entity);
	
	/**
	 * Return all instances of the type with column name equals to column vale.
	 * @param name - name of the column
	 * @param value - value of the column
	 * @return
	 */
	public Iterable<T> findByColumnName(String name, String value);
}
