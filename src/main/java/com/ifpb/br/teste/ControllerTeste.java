package com.ifpb.br.teste;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Amanda
 */
@Named
@RequestScoped
public class ControllerTeste {
    
    TesteReserva reserva = new TesteReserva();
    List<AssentoTeste> lista = null;
    
    public List<AssentoTeste> listar(){
        if (lista == null) {
            lista = reserva.listar();
        }
        return lista;
    }
}
