/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controllers;

import com.ifpb.model.Atracao;
import com.ifpb.atracao.AtracaoIF;
import com.ifpb.atracao.OrdenarPorData;
import com.ifpb.atracao.OrdenarAtracao;
import com.ifpb.atracao.OrdernarPorValor;
import com.ifpb.model.Assento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Cliente
 */
@Named
@RequestScoped
public class ControladorAtracao implements Serializable {

    @EJB
    private AtracaoIF atracao;
    private OrdenarAtracao template;
    
    private Atracao a = new Atracao();
    
    List<Atracao> atracoes = new ArrayList<>();
    
    public String adicionar() {
        setarAssentos();
        this.atracao.persist(this.a);
        this.a = new Atracao();
        listar();
        return "index.xhtml";
    }

    public void remover(Atracao a) {
        atracao.remove(a.getId());
    }

    public Atracao buscar(long id) {
        return atracao.find(id);
    }
    
    @PostConstruct
    public void listar() {
        this.atracoes = atracao.listar();
    }
    
    public String listPorValor(){
        this.template = new OrdernarPorValor();
        this.atracoes = template.listarEventos();
        return null;
    }
    
    public void listPorData(){
        this.template = new OrdenarPorData();
        this.atracoes = this.template.listarEventos();
    }

    public Atracao getA() {
        return a;
    }

    public void setA(Atracao a) {
        this.a = a;
    }

    public List<Atracao> getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(List<Atracao> atracoes) {
        this.atracoes = atracoes;
    }
    
    private void setarAssentos() {
        Assento assento;
        List<Assento> assentos = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            assento = new Assento();
            assento.setNumAssento(i);
            assento.setDisponivel(true);
            assentos.add(assento);
        }
        this.a.setAssentos(assentos);
    }

}
