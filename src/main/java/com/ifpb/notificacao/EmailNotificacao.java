package com.ifpb.notificacao;

import org.apache.commons.mail.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class EmailNotificacao implements NotificacaoIF {

    private static String nome;
    private static String login;
    private static String senha;
    private static String titulo;
    private static String corpo;
    private final String emailDestinatario;

    public EmailNotificacao(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    /**
     * Log
     */
    private static final Logger logger = Logger.getLogger(EmailNotificacao.class.getName());

    /**
     * Leitura do arquivo de properiedades (email.properties) contido em
     * src/main/resources Objetivo é evitar adicionar informações de banco
     * (login, senha) dentro do código
     */
    static {

        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("email.properties");
        try {
            properties.load(inputStream);
            inputStream.close();
            nome = properties.getProperty("email.nome");
            login = properties.getProperty("email.login");
            senha = properties.getProperty("email.senha");
            titulo = properties.getProperty("email.titulo");
            corpo = properties.getProperty("email.corpo");

        } catch (IOException e) {
            logger.severe("Falha ao carregar arquivo de configuração do email");
        }

    }

    /**
     * EmailConfirmacao recebe o email da pessoa a ser notidicada
     */
    @Override
    public void notificacao() {
        try {
            Email email = new SimpleEmail();

            // Configuração
//            email.setHostName("smtp.googlemail.com");
//            email.setSmtpPort(587);
//            email.setStartTLSEnabled(true);
//            email.setSSLOnConnect(true);
//            email.setAuthenticator(new DefaultAuthenticator(login, senha));
//            email.setFrom(login, nome);
//            //
//            email.setSubject(titulo);
//            email.setMsg(corpo);
//            //
//            email.addTo(emailDestinatario);
//            email.send();
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthentication(login, senha);
            email.setStartTLSEnabled(true);
            email.setSSLOnConnect(true);
            email.addTo(emailDestinatario); //pode ser qualquer um email
            email.setFrom(login); //aqui necessita ser o email que voce fara a autenticacao
            email.setSubject("Teste");
            email.setMsg(corpo);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
            logger.severe("houve um erro ao enviar o email de notificação para este destinatário!");
        }
        System.out.println("email enviado");

    }

}
