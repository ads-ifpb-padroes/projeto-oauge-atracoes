/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.atracao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Cliente
 */
@Stateless
public class AtracaoDao implements AtracaoIF {

    EntityManager em = Persistence
            .createEntityManagerFactory("PDP")
            .createEntityManager();

    @Override
    public void persist(Atracao a) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(a);
        transaction.commit();
    }

    @Override
    public Atracao find(long id) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Atracao a;

        a = em.find(Atracao.class, id);

        transaction.commit();
        return a;
    }

    @Override
    public void remove(long id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Atracao a;

        a = em.find(Atracao.class, id);
        em.remove(a);
        transaction.commit();
    }

    @Override
    public List<Atracao> listar() {
        String sql = "SELECT a FROM Atracao a";
        TypedQuery<Atracao> query = em.createQuery(sql, Atracao.class);
        List<Atracao> lista = query.getResultList();
        return lista;
    }

}
