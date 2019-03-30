/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.atracaoController;

import com.ifpb.br.atracao.Atracao;
import com.ifpb.br.atracao.AtracaoDao;
import com.ifpb.br.atracao.AtracaoIF;
import com.ifpb.br.reserva.Assento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    private Atracao a = new Atracao();
    
    public String adicionar() {
        setarAssentos();
        this.atracao.persist(this.a);
        this.a = new Atracao();
        return "index.xhtml";
    }

    public void remover(Atracao a) {
        atracao.remove(a.getId());
    }

    public Atracao buscar(long id) {
        return atracao.find(id);
    }

    public List<Atracao> listar() {
        return atracao.listar();
    }

    public Atracao getA() {
        return a;
    }

    public void setA(Atracao a) {
        this.a = a;
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
