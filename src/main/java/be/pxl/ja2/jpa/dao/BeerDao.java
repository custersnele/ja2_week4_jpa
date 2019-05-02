package be.pxl.ja2.jpa.dao;

import be.pxl.ja2.beers.data.Brewer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BeerDao {

    private EntityManager entityManager;

    public BeerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Brewer findById(Long id) {
        return entityManager.find(Brewer.class, id);
    }

    public List<Beer> findByName(String name) {
        TypedQuery<Beer> query = entityManager.createQuery("from Beer b where b.name like :beerName", Beer.class);
        query.setParameter("beerName", "%" + name + "%");
        return query.getResultList();
    }
}
