/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.relatorio;

import com.ifpb.model.Atracao;
import com.ifpb.model.Relatorio;
import java.util.ArrayList;
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

    EntityManager em = Persistence
            .createEntityManagerFactory("PDP")
            .createEntityManager();

    public List<Relatorio> listarRelatorio(int mes)
    {
        String sql = "SELECT a.nome, a.data, (Count(*) * 100/30) as percentual FROM atracao a "
                + "INNER JOIN atracao_assento ata ON (ata.atracao_id = a.id) "
                + "INNER JOIN assento at ON (at.id = ata.assentos_id) WHERE at.disponivel = false AND extract(month from data) =  ?1 GROUP BY a.nome, a.data;";

        Query query = em.createNativeQuery(sql, "RelatorioMapping");
        query.setParameter(1, mes);
//        query.setParameter("mes", mes);
//        @SuppressWarnings("unchecked")
//        List<Relatorio> lista = query.getResultList();
//        lista.forEach(System.out::println);
//        return lista;
        List<Relatorio> result = new ArrayList<>();
        List<Object[]> objs = query.getResultList();
        for (Object[] o : objs) {

            Object[] aux = o;
            Relatorio r = new Relatorio();
            //Objeto que sualistaModel recebe, vamos chamar de x

            r.setNome((String) aux[0]);
            r.setData((Date) aux[1]);
            r.setPercentual((Long) aux[2]);
            result.add(r);
        }
        return result;
    }
}
