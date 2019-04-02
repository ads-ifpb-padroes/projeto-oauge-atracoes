package com.ifpb.controllers;

import com.ifpb.model.Atracao;
import com.ifpb.model.Assento;
import com.ifpb.reserva.AssentoDBIF;
import com.ifpb.model.Reserva;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.ifpb.model.Notificacao;
import com.ifpb.notificacao.EmailNotificacaoStrategy;
import com.ifpb.notificacao.NotificacaoStrategy;
import com.ifpb.notificacao.SMSNotificacaoStrategy;

/**
 *
 * @author Amanda
 */
@Named
@RequestScoped
public class ControladorReserva implements Serializable {

    @EJB
    private AssentoDBIF assentoDB;
    private int idAssento;
    private Assento assento = new Assento();
    private Reserva reserva = new Reserva();
    private Atracao atracao = new Atracao();
    private NotificacaoStrategy managerNotificacao;
    private Notificacao notificacao = new Notificacao();
    
    public String carregarAtracao(Atracao a){
        this.atracao = a;
        Collections.sort(
                this.atracao.getAssentos(),
                Comparator.comparing(Assento::getId)
        );
        return "reservar.xhtml";
    }
    
    public String reservar() {
        this.assento = buscar();
        this.reserva.setNumReserva(this.assento.getNumAssento());
        this.assento.setReserva(reserva);
        this.assento.setDisponivel(false);
        
        this.assentoDB.merge(this.assento);
        notificar();
       
        return "index.xhtml";
    }
    
    public void notificar(){
        if(!this.notificacao.getEmail().trim().isEmpty()){
            this.managerNotificacao = new EmailNotificacaoStrategy(this.notificacao.getEmail());
            this.managerNotificacao.notificacao();
        }
        if(!this.notificacao.getSms().trim().isEmpty()){
            this.managerNotificacao = new SMSNotificacaoStrategy(this.notificacao.getEmail());
            this.managerNotificacao.notificacao();
        }
    }

    public Assento buscar() {
        return assentoDB.buscar(idAssento);
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public Atracao getAtracao() {
        return atracao;
    }

    public void setAtracao(Atracao atracao) {
        this.atracao = atracao;
    }

    public int getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }
    
}
