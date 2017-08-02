/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.natansevero.entidade;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author natan
 */
public class Carro implements Serializable {
    
    private String placa; //Não pode existir dois carros com a mesma placa
    private String modelo;
    private String fabricante;
    private int ano;
    private String cor;
    private float potencia;
    
    public Carro(){
        
    }

    public Carro(String placa, String modelo, String fabricante, int ano, String cor, float potencia) {
        this.placa = placa;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.ano = ano;
        this.cor = cor;
        this.potencia = potencia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.placa);
        hash = 59 * hash + Objects.hashCode(this.modelo);
        hash = 59 * hash + Objects.hashCode(this.fabricante);
        hash = 59 * hash + this.ano;
        hash = 59 * hash + Objects.hashCode(this.cor);
        hash = 59 * hash + Float.floatToIntBits(this.potencia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.fabricante, other.fabricante)) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        if (Float.floatToIntBits(this.potencia) != Float.floatToIntBits(other.potencia)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "Carro{" + "placa=" + placa + ", modelo=" + modelo + ", fabricante=" + fabricante + ", ano=" + ano + ", cor=" + cor + ", potencia=" + potencia + '}';
    }
    
}
