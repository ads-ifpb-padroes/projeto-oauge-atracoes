package com.ifpb.notificacao;

import com.ifpb.model.Notificacao;

/**
 *
 * @author Amanda
 */
public interface ConfNotificacaoIF {
    public void confNotificacao(Notificacao notificacao);
    public boolean isConfigurado();
    public Notificacao configuracao();
}
