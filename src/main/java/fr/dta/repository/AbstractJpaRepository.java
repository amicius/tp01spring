package fr.dta.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractJpaRepository {

    @PersistenceContext
    EntityManager em;

    protected Session getSession() {
        return em.unwrap( Session.class );
    }

    public void persist( Object entity ) {
        em.persist( entity );
    }

    public void update(Object entity) {
        em.merge( entity );
    }
    public void delete(Object entity) {
        em.remove( entity );
    }

}
