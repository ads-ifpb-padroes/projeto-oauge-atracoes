package com.ifpb.br.ericlys;

public class Evento {

    public Evento() {
    }

    public void notificacao(NotificacaoIF notificacaoMetodo){
        notificacaoMetodo.notificacao();
    }
}
