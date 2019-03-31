package com.ifpb.notificacao;

/**
 *
 * @author Amanda
 */
public interface ConfNotificacaoIF {
    public void confNotificacao(Notificacao notificacao);
    public boolean isConfigurado();
    public void notificar();
    public Notificacao configuracao();
}
