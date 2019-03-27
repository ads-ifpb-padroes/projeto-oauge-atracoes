/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.atracao;

import com.ifpb.br.reserva.Assento;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
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

    private EntityManager em;

    public AtracaoDao() {
        this.em = Persistence
            .createEntityManagerFactory("PDP")
            .createEntityManager();
    }

    @Override
    public void persist(Atracao a) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(a);
        transaction.commit();
    }

    @Override
    public Atracao find(long id) {
        return em.find(Atracao.class, id);
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

    public Atracao buscar(Long id) {
        String sql = "SELECT a FROM Atracao d WHERE a.id = :id";
        TypedQuery<Atracao> query = em.createQuery(sql, Atracao.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

}
