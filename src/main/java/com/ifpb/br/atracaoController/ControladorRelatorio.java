/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.atracaoController;


import com.ifpb.br.relatorio.RelatorioPDF;
import com.ifpb.br.relatorio.GeradorDeRelatorio;
import java.io.IOException;
import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;



/**
 *
 * @author Cliente
 */
@ManagedBean(name = "controladorRelatorio")
@ViewScoped
public class ControladorRelatorio implements Serializable {
   
 GeradorDeRelatorio relatorio = new RelatorioPDF();
   

    public void gerarRelatorio() throws IOException {
       
       this.relatorio.relatorioTemplate();

    }

  
}
