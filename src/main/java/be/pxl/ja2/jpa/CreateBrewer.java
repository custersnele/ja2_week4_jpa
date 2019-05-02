package be.pxl.ja2.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.pxl.ja2.beers.data.Brewer;
import be.pxl.ja2.jpa.dao.BrewerDao;

public class CreateBrewer {

	public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDB");
			EntityManager em = emf.createEntityManager();
			BrewerDao brewerDao = new BrewerDao(em);
			Brewer brewer = new Brewer("PXL Brewery");
			brewer.setAddress("Elfde Liniestraat 11");
			brewer.setZipCode("3500");
            brewer.setCity("Hasselt");
			brewer.setTurnover(1000);
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			brewerDao.save(brewer);
			tx.commit();

			em.close();
			emf.close();
		}

}
