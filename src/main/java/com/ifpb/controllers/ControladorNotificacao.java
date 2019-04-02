package com.ifpb.controllers;

import com.ifpb.notificacao.ConfNotificacaoIF;
import com.ifpb.model.Notificacao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.ifpb.notificacao.NotificacaoStrategy;

/**
 *
 * @author Amanda
 */
@Named
@SessionScoped
public class ControladorNotificacao implements Serializable{
    
    @EJB
    ConfNotificacaoIF managerNotificacao;
    
    private Notificacao notificacao = new Notificacao();
    
    @PostConstruct
    public void configuracaoSet(){
        this.notificacao.setConfigurado(false);
    }
    
    public String configurar(){
        this.notificacao.setConfigurado(true);
        this.managerNotificacao.confNotificacao(this.notificacao);
        return null;
    }
    
    public Notificacao configuracaoNotf(){
        return this.managerNotificacao.configuracao();
    }
    
    public boolean estaConfigurado(){
        return this.managerNotificacao.isConfigurado();
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }
    
}
