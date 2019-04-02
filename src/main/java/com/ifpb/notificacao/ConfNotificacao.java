package com.ifpb.notificacao;

import com.ifpb.model.Notificacao;
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
    private NotificacaoStrategy gerarNotificacao;
    
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
    public Notificacao configuracao() {
        return this.notificacao;
    }
    
}
