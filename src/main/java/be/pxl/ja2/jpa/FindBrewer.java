package be.pxl.ja2.jpa;

import be.pxl.ja2.beers.data.Brewer;
import be.pxl.ja2.jpa.dao.BrewerDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindBrewer {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDB");
        EntityManager em = emf.createEntityManager();
        BrewerDao brewerDao = new BrewerDao(em);
        Brewer brewer = brewerDao.findById(2L);
        System.out.println(brewer.getName());
        System.out.println(brewer.getAddress());
        System.out.println(brewer.getZipCode() + " " + brewer.getCity());
        brewer.getBeers().forEach(b -> System.out.println(b.getName()));
        em.close();
        emf.close();
    }
}
