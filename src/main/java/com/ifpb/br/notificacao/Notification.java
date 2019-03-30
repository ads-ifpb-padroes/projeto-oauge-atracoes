/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.notificacao;

import java.util.concurrent.TimeUnit;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

/**
 *
 * @author Amand
 */
@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 5)
public class Notification {
    
    private String email;
    private String sms;
    private boolean configurado;
    
    public Notification(){
        this.configurado = false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public boolean isConfigurado() {
        return configurado;
    }

    public void setConfigurado(boolean configurado) {
        this.configurado = configurado;
    }
    
}
