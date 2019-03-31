package com.ifpb.br.notificacao;

public class SMSNotificacao implements Notificacao {
    private String numero;

    public SMSNotificacao(String numero) {
        this.numero = numero;
    }

    public void notificacao() {
        System.out.println("O SMS não pode ser enviado para o número "+numero+" pois esta opção ainda não foi implementada");

    }
}
