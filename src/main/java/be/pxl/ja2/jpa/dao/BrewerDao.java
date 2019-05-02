package be.pxl.ja2.jpa.dao;

import be.pxl.ja2.beers.data.Brewer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class BrewerDao {

    private EntityManager entityManager;

    public BrewerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Brewer findById(Long id) {
        return entityManager.find(Brewer.class, id);
    }

    public Brewer save(Brewer brewer) {
        entityManager.persist(brewer);
        return brewer;
    }

    public Brewer update(Brewer brewer) {
        return entityManager.merge(brewer);
    }



    public Brewer findByName(String name) {
        TypedQuery<Brewer> findBrewer = entityManager.createQuery("SELECT b from Brewer as b where b.name = '" + name + "'",
                Brewer.class);
        try {
            return findBrewer.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
