package no.hvl.eao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import no.hvl.entity.Ansatt;
import no.hvl.entity.Prosjekt;
import no.hvl.entity.Prosjektdeltagelse;

public class AnsattEAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ovingPersistenceUnit");

	
	
	public Ansatt finnAnsattMedId(int ansattId) {

		EntityManager em = emf.createEntityManager();

		Ansatt ansatt;

		try {
			ansatt = em.find(Ansatt.class, ansattId);

		} finally {
			em.close();
		}
		return ansatt;
	}

	public Ansatt finnAnsattMedBn(String brukernavn) {
		
		EntityManager em = emf.createEntityManager();
		
		Ansatt ansatt;
		
		try {
			//https://docs.oracle.com/javaee/6/tutorial/doc/bnbtg.html
			TypedQuery<Ansatt> query = em.createQuery(
			"SELECT a FROM Ansatt a WHERE a.brukernavn "
			+ "LIKE :brukernavn", Ansatt.class);
			query.setParameter("brukernavn", brukernavn);
			System.out.println(query);
			ansatt = query.getSingleResult();
			
		} finally {
			em.close();
			
		}
		return ansatt;
	}
	
	public List<Ansatt> finnAlleAnsatte() {
		
	EntityManager em = emf.createEntityManager();
		
	List<Ansatt> ansatt;
		
	try {
		TypedQuery<Ansatt> query = em.createQuery("SELECT ansatt FROM Ansatt ansatt", Ansatt.class);
		ansatt = query.getResultList();
		
	} finally {
		em.close();
		
		}
		return ansatt;
	}
	
	
	public void oppdaterAnsatt(Ansatt ansatt) { //inte ferdig, stilling och eller lonn!

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(ansatt);
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
	
	public void lagreNyAnsatt(Ansatt a) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(a);
			tx.commit();
		
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
				
			}
		} finally {
			em.close();
			
//			public boolean checkIfSjef() {
//				
//						TypedQuery<Ansatt> query = em.createQuery("SELECT ansatt FROM Ansatt ansatt", Ansatt.class);
//				if [select ansattid from ansatt a
//				    join avdeling av on a.ansattid = av.avdelingssjef
//				    where  2 = avdelingssjef;]{
//				return true;
//				} else {
//				return false
//				}`
			
		}
	}

	public void lagreNyProsjekt(Prosjekt prosjekt, Ansatt ansatt) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(prosjekt);
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
	
	public void registrerProsjektdeltagelse(Ansatt a, Prosjekt p, String prosjektRolle) {
			
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			try {
				
				tx.begin();
				a = em.merge(a);
				p = em.merge(p);

			Prosjektdeltagelse pd = new Prosjektdeltagelse(a, p, 0, prosjektRolle );//, 0
				
				a.leggTilProsjektdeltagelse(pd);
				p.leggTilProsjektdeltagelse(pd);
				
				em.persist(pd);
				
				tx.commit();
				
			} catch (Throwable e) {
				e.printStackTrace();;
				if (tx.isActive()) {
					tx.rollback();
				}
			} finally {
				em.close();
			}
		}
	
	
	
//	public void fjernProsjektdeltagelse(Ansatt a, Prosjekt p) {
//		
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		try {
//			tx.begin();
//			
//			//Nytt
//			ProsjektdeltagelsePK pdpk = new ProsjektdeltagelsePK(a.getAnsattId(),p.getProsjektId());
//			
//			Prosjektdeltagelse pd = em.find(Prosjektdeltagelse.class, pdpk);
//			
//			em.remove(pd);
//			
//			em.merge(a).fjernProjekteltagelse(pd);
//			em.merge(p).fjernProjekteltagelse(pd);
//			
//			a.fjernProsjekt(p);
//			p.fjernAnsatt(a);
//			
//			tx.commit();
//			
//		} catch (Throwable e) {
//			e.printStackTrace();;
//			if (tx.isActive()) {
//				tx.rollback();
//			}
//		} finally {
//			em.close();
//		}
//	}
}

//	
//	public List<Ansatt> finnAnsatteMedTekst(String fornavn) {
//
//		EntityManager em = emf.createEntityManager();
//
//		List<Ansatt> ansatt;
//
//		try {
//			// https://docs.oracle.com/javaee/6/tutorial/doc/bnbtg.html
//			TypedQuery<Ansatt> query = em.createQuery("SELECT ansatt FROM Ansatt ansatt WHERE ansatt.fornavn LIKE :fornavn", Ansatt.class);
//			query.setParameter("fornavn", fornavn);
//			ansatt = query.getResultList();
//
//		} finally {
//			em.close();
//		}
//		return ansatt;
//	}
//	
//
//
//	public void slettAnsattMedPk(int pk) {
//
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//
//		try {
//			tx.begin();
//			Ansatt ansatt = em.find(Ansatt.class, pk);
//			em.remove(ansatt);
//			tx.commit();
//
//		} catch (Throwable e) {
//			e.printStackTrace();
//			if (tx.isActive()) {
//				tx.rollback();
//			}
//		} finally {
//			em.close();
//		}
//	}
//}
