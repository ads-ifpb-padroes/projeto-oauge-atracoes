package com.ifpb.br.atracaoController;

import com.ifpb.br.notificacao.Notification;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author Amanda
 */
@ManagedBean(name = "controllerNotificacao")
@SessionScoped
public class ConfigNotificacaoController implements Serializable{
    
//    @EJB
    private Notification notification = new Notification();
    private String email;
    private String numero;
    
    public String addConfiguracao(){
        this.notification.setEmail(email);
        this.notification.setSms(numero);
        this.notification.setConfigurado(true);
        System.out.println("entrei no addConfiguração");
        return null;
    }
    
    public boolean configurado(){
        return this.notification.isConfigurado();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
