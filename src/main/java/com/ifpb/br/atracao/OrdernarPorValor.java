/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.atracao;

/**
 *
 * @author Cliente
 */
public class OrdernarPorValor extends OrdenarTemplate {

    @Override
    protected String consultasql() {
//        return "SELECT a FROM Atracao ORDER BY a.valor ASC";
        return "SELECT * FROM Atracao a ORDER BY a.valor ASC";
    }

}
