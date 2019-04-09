package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ProsjektEAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ovingPersistenceUnit");
	
	public Prosjekt finnAvdelingMedId(int prosjektId) {

		EntityManager em = emf.createEntityManager();

		Prosjekt prosjekt;

		try {
			prosjekt = em.find(Prosjekt.class, prosjektId);

		} finally {
			em.close();
		}
		return prosjekt;
	}
}
