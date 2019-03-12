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
public class OrdenarPorMes  extends OrdenarTemplate{
      @Override
        public String consultasql(){
            
        String sql = "SELECT a FROM atracao a ORDER BY MONTH(a.data)"; 
        return sql;
        
        }
}
