/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.atracao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Cliente
 */
public abstract class OrdenarTemplate {
    
    EntityManager em = Persistence
                .createEntityManagerFactory("PDP")
                .createEntityManager();
    public abstract String consultasql();
    
      private  List<Atracao> listarEventos() {
       
        String sql = consultasql();
        TypedQuery<Atracao> query = em.createQuery(sql, Atracao.class);
        List<Atracao> resultList = query.getResultList();
        
        
        return resultList;
      }
    
}
