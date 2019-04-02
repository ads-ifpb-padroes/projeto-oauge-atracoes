/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controllers;

import com.ifpb.relatorio.RelatorioPDF;
import com.ifpb.relatorio.GeradorDeRelatorio;
import com.ifpb.relatorio.RelatorioList;
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

    private final RelatorioList relatorioList = new RelatorioList();
    private GeradorDeRelatorio relatorio;
    private int mes;

    public void gerarRelatorioPDF() throws IOException {
        relatorio = new RelatorioPDF(
                this.relatorioList.listarRelatorio(mes)
        );
        this.relatorio.relatorioTemplate();
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

}
