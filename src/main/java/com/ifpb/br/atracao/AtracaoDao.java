/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.atracao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Cliente
 */
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

}
