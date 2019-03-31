package com.ifpb.br.ericlys;



public class app {
    public static void main(String[] args) {



        String email = "ericlysm@gmail.com";// email para o qual ira ser enviado a notificação
        String numero = "9746133987";

        Evento evento = new Evento();
        evento.notificacao(new EmailNotificacao(email)); //notificando por email
        evento.notificacao(new SMSNotificacao("numero")); //notificando por sms



    }
}
