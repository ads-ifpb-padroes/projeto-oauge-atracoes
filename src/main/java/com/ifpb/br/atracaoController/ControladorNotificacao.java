package com.ifpb.br.atracaoController;

import com.ifpb.notificacao.ConfNotificacaoIF;
import com.ifpb.notificacao.Notificacao;
import com.ifpb.notificacao.NotificacaoIF;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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
        System.out.println("configurar chamado");
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
