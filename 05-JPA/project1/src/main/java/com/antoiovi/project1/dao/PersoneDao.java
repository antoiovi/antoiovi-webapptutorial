package com.antoiovi.project1.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.antoiovi.project1.model.Persone;

/**
 * DAO for Persone
 */
@Stateless
public class PersoneDao {
	@PersistenceContext(unitName = "antoioviPU")
	private EntityManager em;

	public void create(Persone entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		Persone entity = em.find(Persone.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Persone findById(Integer id) {
		return em.find(Persone.class, id);
	}

	public Persone update(Persone entity) {
		return em.merge(entity);
	}

	public List<Persone> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Persone> findAllQuery = em.createQuery(
				"SELECT DISTINCT p FROM Persone p ORDER BY p.personaId",
				Persone.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
	
	/**
	 * Aggiunto 
	 * @return
	 */
	public List<Persone> listAll() {
		TypedQuery<Persone> findAllQuery = em.createQuery(
				"SELECT DISTINCT p FROM Persone p ORDER BY p.username",
				Persone.class);
		return findAllQuery.getResultList();
	}
}
