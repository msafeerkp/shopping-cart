package org.spinach.cart.data.repositories;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * CrudRepository Implementation.
 * @author safeer
 *
 * @param <T> - Target Class
 * @param <ID> - primary key
 */

public abstract class GenericRepositoryImpl<T,ID extends Serializable> implements GenericRepository<T, ID>{

	private static Logger logger = LoggerFactory.getLogger(GenericRepositoryImpl.class);
	
	private EntityManager entityManager = null;
	
	private CriteriaBuilder criteriaBuilder = null;
	
	private Class<T> persistentClass = null;
	
	@SuppressWarnings("unchecked")
	public GenericRepositoryImpl(){
		super();
		this.persistentClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		logger.debug("CrudRepository is created for - "+this.persistentClass.getClass());
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public CriteriaBuilder getCriteriaBuilder() {
		this.criteriaBuilder = this.entityManager.getCriteriaBuilder();
		return criteriaBuilder;
	}

	public void setCriteriaBuilder(CriteriaBuilder criteriaBuilder) {
		this.criteriaBuilder = criteriaBuilder;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@Override
	//@Transactional(propagation=Propagation.NESTED)
	public <S extends T> S save(S entity) {
		S savedEntity = entityManager.merge(entity);
		entityManager.flush();
		return savedEntity;
	}

	@Override
	public Iterable<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void delete(ID id) {
		T entity = entityManager.find(persistentClass, id);
		entityManager.remove(entity);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void delete(T entity) {
		entityManager.remove(entity);
		
	}
	
	@Override
	public Iterable<T> findByColumnName(String name, String value) {
		CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.getPersistentClass());
		Root<T> entity = criteriaQuery.from(this.getPersistentClass());
		ParameterExpression<String> nameParameter = criteriaBuilder.parameter(String.class);
		criteriaQuery.select(entity).where(criteriaBuilder.equal(entity.get(name), nameParameter));
		TypedQuery<T> query = this.getEntityManager().createQuery(criteriaQuery);
		query.setParameter(nameParameter, value);
		return query.getResultList();
	}
}
