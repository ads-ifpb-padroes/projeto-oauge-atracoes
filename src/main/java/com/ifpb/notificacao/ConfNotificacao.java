package com.ifpb.notificacao;

import java.util.concurrent.TimeUnit;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

/**
 *
 * @author Amanda
 */
@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 5)
public class ConfNotificacao implements ConfNotificacaoIF{
    
    private Notificacao notificacao = new Notificacao();
    
    @Override
    public void confNotificacao(Notificacao notificacao){
        this.notificacao = notificacao;
        System.out.println("configurado email: " + this.notificacao.getEmail());
    }

    @Override
    public boolean isConfigurado(){
        return notificacao.isConfigurado();
    }

    @Override
    public void notificar() {
        Evento evento = new Evento();
        System.out.println("notificar");
        System.out.println("email: " + notificacao.getEmail());
        if(!notificacao.getEmail().trim().isEmpty()){
            evento.notificacao(new EmailNotificacao(notificacao.getEmail()));
        }
        if(!notificacao.getSms().trim().isEmpty()){
            evento.notificacao(new SMSNotificacao(notificacao.getSms()));
        }
    }

    @Override
    public Notificacao configuracao() {
        return this.notificacao;
    }
    
}
