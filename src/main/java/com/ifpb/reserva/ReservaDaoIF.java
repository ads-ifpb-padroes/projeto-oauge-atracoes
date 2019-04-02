package com.ifpb.reserva;

import com.ifpb.model.Reserva;

/**
 *
 * @author Amanda
 */
public interface ReservaDaoIF {
    public void persist(Reserva reserva);
    public Reserva find(long id);
}
