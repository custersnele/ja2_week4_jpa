package be.pxl.ja2.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.pxl.ja2.beers.data.Brewer;

public class UpdateBrewerCity {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDB");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Brewer westvleteren = em.find(Brewer.class, 124);
		System.out.println(westvleteren);
		westvleteren.setCity("Oostvleteren");
		tx.commit();

		em.close();
		emf.close();
	}
}
