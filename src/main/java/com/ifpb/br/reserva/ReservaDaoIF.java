package com.ifpb.br.reserva;

/**
 *
 * @author Amanda
 */
public interface ReservaDaoIF {
    public void persist(Reserva reserva);
    public Reserva find(long id);
}
