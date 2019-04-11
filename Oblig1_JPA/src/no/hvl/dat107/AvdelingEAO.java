package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AvdelingEAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ovingPersistenceUnit");

	public Avdeling finnAvdelingMedId(int avdelingId) {

		EntityManager em = emf.createEntityManager();

		Avdeling avdeling;

		try {
			avdeling = em.find(Avdeling.class, avdelingId);

		} finally {
			em.close();
		}
		return avdeling;
	}

	public Avdeling finnAvdelingMedNavn(String navn) {

		EntityManager em = emf.createEntityManager();

		Avdeling avdeling;

		try {
			// https://docs.oracle.com/javaee/6/tutorial/doc/bnbtg.html
			TypedQuery<Avdeling> query = em
					.createQuery("SELECT a FROM Avdeling a WHERE a.avdelingnavn " 
			+ "LIKE :avdelingnavn", Avdeling.class);
			query.setParameter("avdelingnavn", navn);
			avdeling = query.getSingleResult();

		} finally {
			em.close();

		}
		return avdeling;
	}

	public List<Avdeling> finnAlleAvdelinger() {

		EntityManager em = emf.createEntityManager();

		List<Avdeling> avdeling;

		try {
			TypedQuery<Avdeling> query = em.createQuery("SELECT avdeling FROM Avdeling avdeling", Avdeling.class);
			avdeling = query.getResultList();

		} finally {
			em.close();

		}
		return avdeling;
	}

	public void oppdaterAvdeling(Avdeling avdeling) { 

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(avdeling);
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

	public void lagreNyAvdeling(Avdeling avdelingny) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(avdelingny);
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

	
	
		public void slettAvdelingMedPk(int pk) {
	
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
	
			try {
				tx.begin();
				Avdeling avdeling = em.find(Avdeling.class, pk);
				em.remove(avdeling);
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
