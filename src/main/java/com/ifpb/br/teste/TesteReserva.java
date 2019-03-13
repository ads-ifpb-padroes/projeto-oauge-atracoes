package com.ifpb.br.teste;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Amanda
 */
public class TesteReserva {
    
    EntityManager em = Persistence
                .createEntityManagerFactory("PDP")
                .createEntityManager();

    public TesteReserva() {
        adicionar();
    }
    
    public void adicionar(){
        AssentoTeste assento1 = new AssentoTeste(1, true);
        AssentoTeste assento2 = new AssentoTeste(2, true);
        AssentoTeste assento3 = new AssentoTeste(3, false);
        AssentoTeste assento4 = new AssentoTeste(4, true);
        AssentoTeste assento5 = new AssentoTeste(5, true);
        
        em.getTransaction().begin();
        em.persist(assento1);
        em.persist(assento2);
        em.persist(assento3);
        em.persist(assento4);
        em.persist(assento5);
        em.getTransaction().commit();
    }
    
    public List<AssentoTeste> listar(){
        String sql = "SELECT a FROM Assento a";
        TypedQuery<AssentoTeste> query = em.createQuery(sql, AssentoTeste.class);
        List<AssentoTeste> lista = query.getResultList();
        return lista;
    }
}
