package be.pxl.ja2.jpa;

import be.pxl.ja2.beers.data.Brewer;
import be.pxl.ja2.beers.data.BrewingDeclaration;
import be.pxl.ja2.beers.data.BrewingDeclarationState;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CreateBrewingDeclaration {
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Geef brouwer:");
		String brouwer = scanner.nextLine();
		System.out.println("Geef brouwdatum (dd-MM-yyyy)");
		LocalDate brewingdate = LocalDate.parse(scanner.nextLine(), DATE_FORMAT);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDB");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Brewer> findBrewer =
				em.createQuery("SELECT b from Brewer b where b.name = '" + brouwer + "'", Brewer.class);
		Brewer brewer = findBrewer.getSingleResult();
		BrewingDeclaration declaration = new BrewingDeclaration();
		declaration.setBrewer(brewer);
		declaration.setBrewingdate(brewingdate);
		declaration.setState(BrewingDeclarationState.OPEN);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(declaration);
		tx.commit();

		System.out.println("Generated id:" + declaration.getId());
		em.close();
		emf.close();
		scanner.close();
	}
}
