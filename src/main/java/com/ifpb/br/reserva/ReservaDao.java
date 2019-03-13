package com.ifpb.br.reserva;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Amanda
 */
@Stateless
public class ReservaDao implements ReservaDaoIF{
    
    EntityManager em = Persistence
            .createEntityManagerFactory("PDP")
            .createEntityManager();

    @Override
    public void persist(Reserva reserva) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(reserva);
        transaction.commit();
    }
    
    @Override
    public Reserva find(long id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Reserva reserva = em.find(Reserva.class, id);
        transaction.commit();
        return reserva;
    }
}
