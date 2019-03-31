/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.br.atracao;

import com.ifpb.br.reserva.Assento;
import com.ifpb.br.reserva.Reserva;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Cliente
 */
@Entity
@Table(name = "Atracao")
public class Atracao implements Serializable {

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    private long id;
    @Column(length = 100, nullable = false)
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date data;
    private float valor;
    private int minutos;
//    @OneToMany
//    private List<Reserva> reservas;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Assento> assentos;

    public Atracao(String nome, Date data, float valor, int minutos) {
        this.nome = nome;
        this.data = data;
        this.valor = valor;
        this.minutos = minutos;
    }

    public Atracao() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

//    public List<Reserva> getReservas() {
//        return reservas;
//    }
//
//    public void setReservas(List<Reserva> reservas) {
//        this.reservas = reservas;
//    }
    public List<Assento> getAssentos() {
        return this.assentos;
    }

    public void setAssentos(List<Assento> assentos) {
        this.assentos = assentos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.data);
        hash = 59 * hash + Float.floatToIntBits(this.valor);
        hash = 59 * hash + this.minutos;
//        hash = 59 * hash + Objects.hashCode(this.reservas);
        hash = 59 * hash + Objects.hashCode(this.assentos);
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
        final Atracao other = (Atracao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (this.minutos != other.minutos) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
//        if (!Objects.equals(this.reservas, other.reservas)) {
//            return false;
//        }
        if (!Objects.equals(this.assentos, other.assentos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Atracao{" + "id=" + id + ", nome=" + nome + ", data=" + data
                + ", valor=" + valor + ", minutos=" + minutos + ", reservas=" + "" + ", assentos=" + assentos + '}';
    }

}
