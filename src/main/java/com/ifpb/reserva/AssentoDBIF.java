package com.ifpb.reserva;

import com.ifpb.model.Assento;

/**
 *
 * @author Amanda
 */
public interface AssentoDBIF {
    
    public Assento buscar(int id);
    public void merge(Assento assento);
}
