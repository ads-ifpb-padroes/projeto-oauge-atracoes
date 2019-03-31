package com.ifpb.notificacao;

public class Evento {

    public Evento() {
    }

    public void notificacao(NotificacaoIF notificacaoMetodo){
        notificacaoMetodo.notificacao();
    }
}
