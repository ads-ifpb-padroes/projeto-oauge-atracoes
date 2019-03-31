/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Cliente
 */
public class Relatorio implements Serializable {

    private String nome;
    private Date data;
    private double percentual;

    public Relatorio(String nome, Date data, double percentual) {
        this.nome = nome;
        this.data = data;
        this.percentual = percentual;
    }

    public Relatorio() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.data);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.percentual) ^ (Double.doubleToLongBits(this.percentual) >>> 32));
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
        final Relatorio other = (Relatorio) obj;
        if (Double.doubleToLongBits(this.percentual) != Double.doubleToLongBits(other.percentual)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Relatorio{" + "nome=" + nome + ", data=" + data + ", percentual=" + percentual + '}';
    }

    

   
   

}
