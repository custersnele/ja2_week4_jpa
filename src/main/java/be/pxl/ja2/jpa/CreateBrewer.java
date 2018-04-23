package be.pxl.ja2.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.pxl.ja2.beers.data.Brewer;

public class CreateBrewer {

	public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDB");
			EntityManager em = emf.createEntityManager();
			Brewer brewer = new Brewer();
			brewer.setName("PXL Brewery");
			brewer.setAddress("Elfde Liniestraat 11");
			brewer.setZipCode("3500");
			brewer.setTurnover(1000);
			brewer.setCity("Hasselt");
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(brewer);
			tx.commit();

			em.close();
			emf.close();
		}

}
