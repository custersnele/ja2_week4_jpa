package be.pxl.ja2.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import be.pxl.ja2.beers.data.Brewer;

public class AcceptAllDeclarations {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Geef brouwer:");
		String brouwer = scanner.nextLine();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDB");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Brewer> findBrewer = em.createQuery("SELECT b from Brewer as b where b.name = '" + brouwer + "'",
				Brewer.class);
		Brewer brewer = findBrewer.getSingleResult();
		// TODO implement update all brewing declarations
		tx.commit();
		em.close();
		emf.close();
		scanner.close();
	}
}
