/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.atracao;

import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Cliente
 */
public  class OrdenarPorData extends OrdenarTemplate{
    
    @Override
        public String consultasql(){
            
        String sql = "SELECT a FROM atracao ORDER BY a.data ASC"; 
        return sql;
        
        }
            
            
        
}
