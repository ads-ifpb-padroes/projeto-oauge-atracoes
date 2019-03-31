package com.ifpb.br.atracaoController;

import com.ifpb.br.atracao.Atracao;
import com.ifpb.br.ericlys.EmailNotificacao;
import com.ifpb.br.ericlys.Evento;
import com.ifpb.br.ericlys.Notification;
import com.ifpb.br.ericlys.SMSNotificacao;
import com.ifpb.br.reserva.Assento;
import com.ifpb.br.reserva.AssentoDBIF;
import com.ifpb.br.reserva.Reserva;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.ifpb.br.ericlys.NotificacaoIF;
import com.ifpb.notificacao.ConfNotificacaoIF;
import com.ifpb.notificacao.Notificacao;

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
    private Evento managerNotificacao = new Evento();
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
        this.assento.setReserva(reserva);
        this.assento.setDisponivel(false);
        
        this.assentoDB.merge(this.assento);
        System.out.println("controlador reserva email: "  + this.notificacao.getEmail());   
            
        notificar();
        
        return "index.xhtml";
    }
    
    public void notificar(){
        if(!this.notificacao.getEmail().trim().isEmpty()){
            this.managerNotificacao.notificacao(new EmailNotificacao(this.notificacao.getEmail())); ;
        }
        if(!this.notificacao.getSms().trim().isEmpty()){
            this.managerNotificacao.notificacao(new SMSNotificacao(this.notificacao.getSms()));
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
