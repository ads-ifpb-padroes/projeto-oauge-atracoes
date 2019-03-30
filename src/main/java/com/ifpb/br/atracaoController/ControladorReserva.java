package com.ifpb.br.atracaoController;

import com.ifpb.br.atracao.Atracao;
import com.ifpb.br.notificacao.EmailNotificacao;
import com.ifpb.br.notificacao.Evento;
import com.ifpb.br.notificacao.Notificacao;
import com.ifpb.br.notificacao.Notification;
import com.ifpb.br.notificacao.SMSNotificacao;
import com.ifpb.br.reserva.Assento;
import com.ifpb.br.reserva.AssentoDBIF;
import com.ifpb.br.reserva.Reserva;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

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
    private Evento managerNorificacao;
    private final Notification notification = new Notification();
    
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
        this.assento.setReserva(reserva);
        this.assento.setDisponivel(false);
        
        this.assentoDB.merge(this.assento);
        
//        notificar();
        
        return "index.xhtml";
    }
    
//    public void notificar(){
//        if(!notification.getEmail().trim().isEmpty()){
//            this.managerNorificacao.notificacao(new EmailNotificacao(notification.getEmail())); ;
//        }
//        if(!notification.getSms().trim().isEmpty()){
//            this.managerNorificacao.notificacao(new SMSNotificacao(notification.getSms()));
//        }
//    }

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
    
}
