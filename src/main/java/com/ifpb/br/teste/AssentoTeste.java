package com.ifpb.br.teste;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Amanda
 */
@Entity
public class AssentoTeste {
    
    @Id
    private int id;
    private boolean disponivel;

    public AssentoTeste(int id, boolean disponivel) {
        this.id = id;
        this.disponivel = disponivel;
    }

    public AssentoTeste() {
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + (this.disponivel ? 1 : 0);
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
        final AssentoTeste other = (AssentoTeste) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.disponivel != other.disponivel) {
            return false;
        }
        return true;
    }
    
}
