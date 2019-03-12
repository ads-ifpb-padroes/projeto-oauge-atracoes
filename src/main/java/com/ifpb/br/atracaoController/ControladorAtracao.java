/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.atracaoController;

import com.ifpb.br.atracao.Atracao;
import com.ifpb.br.atracao.AtracaoDao;
import com.ifpb.br.atracao.AtracaoIF;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Cliente
 */
public class ControladorAtracao implements Serializable {
    @EJB
    AtracaoIF atracao;
    Atracao a ;
    
        public void adicionar(){
       atracao.persist(this.a);
    }
      public void remover(Atracao a){
      atracao.remove(a.getId());
      
    }
      
   public Atracao buscar(){
   
     
       return atracao.find(this.a.getId());
   }
   
   
   
   

    

    public Atracao getA() {
        return a;
    }

    public void setA(Atracao a) {
        this.a = a;
    }
       
       
       
}
