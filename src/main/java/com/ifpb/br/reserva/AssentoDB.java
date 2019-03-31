package com.ifpb.br.reserva;

import com.ifpb.model.Assento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Amanda
 */
@Stateless
public class AssentoDB implements AssentoDBIF{
    
    @PersistenceContext(unitName = "PDP")
    EntityManager em;

//    public AssentoDB() {
//        this.em = Persistence
//            .createEntityManagerFactory("PDP")
//            .createEntityManager();
//    }

    @Override
    public Assento buscar(int id) {
        return em.find(Assento.class, id);
    }

    @Override
    public void merge(Assento assento) {
        em.merge(assento);
    }
    
}
