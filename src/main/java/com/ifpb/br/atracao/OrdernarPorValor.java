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
        public String consultasql(){
        
        
        String sql = "SELECT a FROM atracao ORDER BY a.valor ASC"; 
        return sql;
        }
      
        
        
}
