/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.atracao;

import com.ifpb.model.Atracao;
import java.util.List;

/**
 *
 * @author Cliente
 */
public interface AtracaoIF {
    public void persist(Atracao a);
    public Atracao find(long id);
    public List<Atracao> listar();
    public void remove(long id);
}
