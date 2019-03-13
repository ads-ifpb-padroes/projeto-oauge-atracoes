package com.ifpb.br.atracaoController;

import com.ifpb.br.reserva.Reserva;
import com.ifpb.br.reserva.ReservaDaoIF;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Amanda
 */
@Named
@RequestScoped
public class ControladorReserva implements Serializable{
    
    @EJB
    private ReservaDaoIF reservaDaoIF;
    private Reserva reserva = new Reserva();
    
    public String reservar(){
        reserva.setDisponivel(false);
        this.reservaDaoIF.persist(
            this.reserva
        );
        this.reserva = new Reserva();
        return "index.xhtml";
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
}
