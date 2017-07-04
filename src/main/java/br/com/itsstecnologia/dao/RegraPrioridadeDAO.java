package br.com.itsstecnologia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.itsstecnologia.enums.PrioridadeEnum;
import br.com.itsstecnologia.model.RegraPrioridade;

public class RegraPrioridadeDAO {

	private static RegraPrioridadeDAO instance;
	protected EntityManager entityManager;

	public static RegraPrioridadeDAO getInstance() {
		if (instance == null) {
			instance = new RegraPrioridadeDAO();
		}

		return instance;
	}

	private RegraPrioridadeDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("running");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public RegraPrioridade findById(Long id) {
		EntityManager entityManager = getEntityManager();
		RegraPrioridade regra = null;
		try {
			regra = entityManager.find(RegraPrioridade.class, id);
		} finally {
			entityManager.close();
		}
		return regra;
	}

	public RegraPrioridade getById(final int id) {
		return entityManager.find(RegraPrioridade.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<RegraPrioridade> findAll() {
		return entityManager.createQuery("FROM tb_reg_prioridade").getResultList();
	}

	public void persist(RegraPrioridade regra) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(regra);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(RegraPrioridade regra) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(regra);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(RegraPrioridade regra) {
		try {
			entityManager.getTransaction().begin();
			regra = entityManager.find(RegraPrioridade.class, regra.getId());
			entityManager.remove(regra);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			RegraPrioridade regra = getById(id);
			remove(regra);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int getHora(String empresa, PrioridadeEnum prioridade) {
		int hora = 0;
		try {
			Query query = entityManager
					.createQuery("select hora from RegraPrioridade where empresa = ?1 and prioridade = ?2");
			query.setParameter(1, empresa);
			query.setParameter(2, prioridade);
			hora = (Integer) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return hora;
	}

}
