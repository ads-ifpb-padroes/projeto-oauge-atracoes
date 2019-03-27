package com.ifpb.br.reserva;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Amanda
 */
@Stateless
public class AssentoDB implements AssentoDBIF{
    
    private final EntityManager em;

    public AssentoDB() {
        this.em = Persistence
            .createEntityManagerFactory("PDP")
            .createEntityManager();
    }

    @Override
    public Assento buscar(int id) {
        return em.find(Assento.class, id);
    }

    @Override
    public void merge(Assento assento) {
        em.getTransaction().begin();
        em.merge(assento);
        em.getTransaction().commit();
    }
    
}
