/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.atracao;

import com.ifpb.model.Atracao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Cliente
 */
@Stateless
public class AtracaoDao implements AtracaoIF {

    @PersistenceContext(unitName = "PDP")
    EntityManager em;

//    public AtracaoDao() {
//        this.em = Persistence
//            .createEntityManagerFactory("PDP")
//            .createEntityManager();
//    }

    @Override
    public void persist(Atracao a) {
        em.persist(a);
    }

    @Override
    public Atracao find(long id) {
        return em.find(Atracao.class, id);
    }

    @Override
    public void remove(long id) {
        Atracao a = em.find(Atracao.class, id);
        em.remove(a);
    }

    @Override
    public List<Atracao> listar() {
        String sql = "SELECT a FROM Atracao a";
        TypedQuery<Atracao> query = em.createQuery(sql, Atracao.class);
        List<Atracao> lista = query.getResultList();
        return lista;
    }

}
