package be.pxl.ja2.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.pxl.ja2.beers.data.Brewer;
import be.pxl.ja2.jpa.dao.BrewerDao;

public class UpdateBrewer {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDB");
		EntityManager em = emf.createEntityManager();
        BrewerDao brewerDao = new BrewerDao(em);
        Brewer westvleteren = brewerDao.findById(124L);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		westvleteren.setCity("Oostvleteren");
		tx.commit();

		em.close();
		emf.close();
	}
}
