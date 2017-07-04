package br.com.itsstecnologia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.itsstecnologia.model.Demanda;


public class DemandaDAO {

	private static DemandaDAO instance;
    protected EntityManager entityManager;
    
    public static DemandaDAO getInstance(){
              if (instance == null){
                       instance = new DemandaDAO();
              }
              
              return instance;
    }

    private DemandaDAO() {
              entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
              EntityManagerFactory factory = Persistence.createEntityManagerFactory("running");
              if (entityManager == null) {
                       entityManager = factory.createEntityManager();
              }

              return entityManager;
    }

    public Demanda getById(final int id) {
              return entityManager.find(Demanda.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Demanda> findAll() {
              return entityManager.createQuery("FROM " + Demanda.class.getName()).getResultList();
    }

    public void persist(Demanda demanda) {
              try {
            	  if(entityManager.find(Demanda.class, (long) demanda.getId()) == null) {
                       entityManager.getTransaction().begin();
                       entityManager.persist(demanda);
                       entityManager.getTransaction().commit();
            	  } else {
            		  merge(demanda);
            	  }
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void merge(Demanda demanda) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.merge(demanda);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void remove(Demanda demanda) {
              try {
                       entityManager.getTransaction().begin();
                       demanda = entityManager.find(Demanda.class, demanda.getId());
                       entityManager.remove(demanda);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void removeById(final int id) {
              try {
                       Demanda demanda = getById(id);
                       remove(demanda);
              } catch (Exception ex) {
                       ex.printStackTrace();
              }
    }
}
