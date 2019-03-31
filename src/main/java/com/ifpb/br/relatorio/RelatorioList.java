/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.relatorio;

import com.ifpb.br.atracao.Atracao;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Cliente
 */
public class RelatorioList {

//    EntityManager em = Persistence
//            .createEntityManagerFactory("PDP")
//            .createEntityManager();
    @PersistenceContext
    EntityManager em;

    public List<Atracao> listarRelatorio()//Date mes) 
    {
        String sql = "SELECT a FROM Atracao a";
        TypedQuery<Atracao> query = em.createQuery(sql, Atracao.class);
        // query.setParameter("mes", mes);
        List<Atracao> resultList = query.getResultList();
        return resultList;

    }
}
