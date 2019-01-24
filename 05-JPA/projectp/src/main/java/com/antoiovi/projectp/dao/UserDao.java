package com.antoiovi.projectp.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.antoiovi.projectp.model.User;

/**
 * Session Bean implementation class UserDao
 */
@Stateless
@LocalBean
public class UserDao implements UserDaoRemote, UserDaoLocal {

	@PersistenceContext(unitName="prod")
    EntityManager em;

	
    /**
     * Default constructor. 
     */
    public UserDao() {
        // TODO Auto-generated constructor stub
    }
 

/**
 * DAO for Persone
 */
@Stateless
public class PersoneDao {
	@PersistenceContext(unitName = "antoioviPU")
	private EntityManager em;

	public void create(User entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		User entity = em.find(User.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public User findById(Integer id) {
		return em.find(User.class, id);
	}

	public User update(User entity) {
		return em.merge(entity);
	}

	public List<User> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<User> findAllQuery = em.createQuery(
				"SELECT DISTINCT p FROM user p ORDER BY p.userId",
				User.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
	
	/**
	 * @return
	 */
	public List<User> listAll() {
		TypedQuery<User> findAllQuery = em.createQuery(
				"SELECT DISTINCT p FROM User p ORDER BY p.username",
				User.class);
		return findAllQuery.getResultList();
	}
}

   
    
}
