package com.ifpb.notificacao;

public class SMSNotificacaoStrategy implements NotificacaoStrategy {
    private String numero;

    public SMSNotificacaoStrategy(String numero) {
        this.numero = numero;
    }

    public void notificacao() {
        System.out.println("O SMS não pode ser enviado para o número "+numero+" pois esta opção ainda não foi implementada");

    }
}
