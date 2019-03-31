package com.ifpb.br.ericlys;

public class SMSNotificacao implements NotificacaoIF {
    private String numero;

    public SMSNotificacao(String numero) {
        this.numero = numero;
    }

    public void notificacao() {
        System.out.println("O SMS não pode ser enviado para o número "+numero+" pois esta opção ainda não foi implementada");

    }
}
