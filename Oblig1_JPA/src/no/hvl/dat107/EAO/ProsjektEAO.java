package no.hvl.dat107.EAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import no.hvl.dat107.Prosjekt;

public class ProsjektEAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ovingPersistenceUnit");
	
	public Prosjekt finnProsjektMedId(int prosjektId) {

		EntityManager em = emf.createEntityManager();

		Prosjekt prosjekt;

		try {
			prosjekt = em.find(Prosjekt.class, prosjektId);

		} finally {
			em.close();
		}
		return prosjekt;
	}
	
	public Prosjekt finnProsjektMedNavn(String navn) {

		EntityManager em = emf.createEntityManager();

		Prosjekt prosjekt;

		try {
			// https://docs.oracle.com/javaee/6/tutorial/doc/bnbtg.html
			TypedQuery<Prosjekt> query = em
					.createQuery("SELECT a FROM Prosjekt a WHERE a.prosjektnavn " 
			+ "LIKE :prosjektnavn", Prosjekt.class);
			query.setParameter("prosjektnavn", navn);
			prosjekt = query.getSingleResult();

		} finally {
			em.close();

		}
		return prosjekt;
	}
	
	public List<Prosjekt> finnAlleProsjekter() {

		EntityManager em = emf.createEntityManager();

		List<Prosjekt> prosjekt;

		try {
			TypedQuery<Prosjekt> query = em.createQuery("SELECT prosjekt FROM Prosjekt prosjekt", Prosjekt.class);
			prosjekt = query.getResultList();

		} finally {
			em.close();

		}
		return prosjekt;
	}

	public void oppdaterProsjekt(Prosjekt prosjekt) { 

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(prosjekt);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	public void lagreNyProsjekt(Prosjekt prosjektny) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(prosjektny);
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();

			}
		} finally {
			em.close();
		}
	}
}
