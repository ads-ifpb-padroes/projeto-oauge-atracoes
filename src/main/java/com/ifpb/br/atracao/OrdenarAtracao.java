/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.atracao;

import com.ifpb.model.Atracao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Cliente
 */
public abstract class OrdenarAtracao {

    EntityManager em = Persistence.createEntityManagerFactory("PDP").createEntityManager();

    protected abstract String consultasql();

    public List<Atracao> listarEventos() {
        String sql = consultasql();
        Query createNativeQuery = em.createNativeQuery(sql, Atracao.class);
        List<Atracao> resultList = createNativeQuery.getResultList();
        return resultList;
    }

}
