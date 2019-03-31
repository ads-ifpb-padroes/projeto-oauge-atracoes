package com.ifpb.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Amanda
 */
@Entity
public class Assento implements Serializable{
    
    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    private int id;
    private int numAssento;
    private boolean disponivel;
    @OneToOne(cascade = CascadeType.ALL)
    private Reserva reserva;

    public Assento() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getNumAssento() {
        return numAssento;
    }

    public void setNumAssento(int numAssento) {
        this.numAssento = numAssento;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + this.numAssento;
        hash = 37 * hash + (this.disponivel ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.reserva);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Assento other = (Assento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numAssento != other.numAssento) {
            return false;
        }
        if (this.disponivel != other.disponivel) {
            return false;
        }
        if (!Objects.equals(this.reserva, other.reserva)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Assento{" + "id=" + id + ", numAssento=" + numAssento + ", disponivel=" + disponivel + ", reserva=" + reserva + '}';
    }
    
}
