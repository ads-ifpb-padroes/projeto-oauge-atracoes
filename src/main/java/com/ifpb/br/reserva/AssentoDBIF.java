package com.ifpb.br.reserva;

/**
 *
 * @author Amanda
 */
public interface AssentoDBIF {
    
    public Assento buscar(int id);
    public void merge(Assento assento);
}
