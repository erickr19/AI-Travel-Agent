package com.aiagent.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A generic DAO to interact with entities.
 * @param <T> The type of entity to create a DAO for
 * @author ereyes3
 */
public class GenericDao<T> {
    // instance variable
    private Class<T> type;

    // instantiate logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // constructors

    /**
     * Creates a new DAO for the given type
     * @param type the entity type/name
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    // CRUD operations

    /**
     * Inserts a new entity into the database
     * @param entity the entity to insert
     * @return id of newly created entity
     */
    // insert
    public int insert(T entity) {
        // instance variables
        int id = 0;
        Transaction tx = null;

        // try to insert into db
        try (Session session = getSession()) {
            tx = session.beginTransaction();
            id = (int)session.save(entity);
            tx.commit();
        } catch (HibernateException hibernateE) {
            if (tx != null) tx.rollback();
            logger.error("Hibernate Exception: failed to insert", hibernateE);
        }
        // return id
        return id;
    }

    /**
     * Gets by id
     * @param id the entity with given id
     * @return entity
     */
    // get
    public T getById(int id) {
        // instance variables
        T entity = null;
        Transaction tx = null;

        try (Session session = getSession()) {
            tx = session.beginTransaction();
            entity = (T) session.get(type, id);
            tx.commit();
        } catch (HibernateException hibernateE) {
            if (tx != null) tx.rollback();
            logger.error("Hibernate Exception: failed to get by id", hibernateE);
        }
        // return entity
        return entity;
    }

    /**
     * Update entity
     * @param entity The entity to update
     */
    // update
    public void update(T entity) {
        // instance variables
        Transaction tx = null;

        try (Session session = getSession()) {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        } catch (HibernateException hibernateE) {
            if (tx != null) tx.rollback();
            logger.error("Hibernate Exception: failed to update", hibernateE);
        }
    }

    // delete

    /**
     * Deletes entity
     * @param entity The entity to delete
     */
    public void delete(T entity) {
        // instance variables
        Transaction tx = null;

        try (Session session = getSession()) {
            tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        } catch (HibernateException hibernateE) {
            if (tx != null) tx.rollback();
            logger.error("Hibernate Exception: failed to get by id", hibernateE);
        }
    }

    /**
     * Gets all entities
     * @return entities
     */
    public List<T> getAll() {
        return getSession().createQuery("from " + type.getName()).list();
    }

    /**
     * Gets open session from factory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Finds entities with given property
     * @param propertyName the property to look for
     * @param value the value of the property
     * @return list of entities with property
     */
    public List<T> findByPropertyEqual(String propertyName, Object value) {
        // get session
        Session session = getSession();
        // create criteria builder
        CriteriaBuilder builder = session.getCriteriaBuilder();
        // create query
        CriteriaQuery<T> query = builder.createQuery(type);
        // get root type from query
        Root<T> root = query.from(type);
        // query
        query.select(root).where(builder.equal(root.get(propertyName), value));
        // execute query and return list
        return session.createQuery(query).getResultList();
    }

    /**
     * Finds entities by multiple properties
     * @param propertyMap Thr properties to look for
     * @return list of entities with given properties
     */
//    public List<T> findByProperties(Map<String, Object> propertyMap) {
//        // get session
//        Session session = getSession();
//        // create criteria builder
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        // create query
//        CriteriaQuery<T> query = builder.createQuery(type);
//        // get root type from query
//        Root<T> root = query.from(type);
//        // create list of properties to search for
//        List<Predicate> predicates = new ArrayList<>();
//        // iterate through entities, getting matches
//        for (Map.Entry entry: propertyMap.entrySet()) {
//            predicates.add(builder.equal(root.get((String) entry.getKey()), entry.getValue()));
//        }
//        // query for entities with matching properties
//        query.select(root).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
//        // return list of entities
//        return session.createQuery(query).getResultList();
//    }
}
