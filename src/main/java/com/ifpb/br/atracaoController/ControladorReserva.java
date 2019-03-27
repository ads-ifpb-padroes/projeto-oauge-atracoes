package com.ifpb.br.atracaoController;

import com.ifpb.br.atracao.Atracao;
import com.ifpb.br.atracao.AtracaoDao;
import com.ifpb.br.atracao.AtracaoIF;
import com.ifpb.br.reserva.Assento;
import com.ifpb.br.reserva.AssentoDBIF;
import com.ifpb.br.reserva.Reserva;
import com.ifpb.br.reserva.ReservaDaoIF;
import java.io.Serializable;
import java.util.List;
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
    private AtracaoIF atracaoDao;
    @EJB
    private AssentoDBIF assentoDB;
    private Assento assento = new Assento();
    private Reserva reserva = new Reserva();
    private Atracao atracao = new Atracao();

    public String carregarAtracao(Atracao a){
        this.atracao = a;
        return "reservar.xhtml";
    }
    
    public String reservar() {
        System.out.println("Num reserva: " + assento.getNumAssento());
        atracao = atracaoDao.find(atracao.getId());
        Assento a = buscar();
        a.setReserva(reserva);
        a.setDisponivel(false);
        assentoDB.merge(a);

        return "index.xhtml";
    }

    public Assento buscar() {
        List<Assento> assentos = atracao.getAssentos();
        for (Assento a : assentos) {
            if (a.getNumAssento() == assento.getNumAssento()) {
                System.out.println("Assento encontrado!!");
                return assentoDB.buscar(a.getId());
            }
        }
        return null;
    }

//    public String reservar() {
//        reserva.setDisponivel(false);
//        this.reservaDaoIF.persist(
//                this.reserva
//        );
//        this.reserva = new Reserva();
//        return "index.xhtml";
//    }
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

}
