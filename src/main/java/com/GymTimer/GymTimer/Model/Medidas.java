package com.GymTimer.GymTimer.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Medidas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeMusculo;
    private double medidaAtual;
    private double medidaAnterior;

    public Medidas() {
    }

    public Medidas(String nomeMusculo, double medidaAtual, double medidaAnterior) {
        this.nomeMusculo = nomeMusculo;
        this.medidaAtual = medidaAtual;
        this.medidaAnterior = medidaAnterior;
    }

    @Override
    public String toString() {
        return "Medidas{" +
                "id=" + id +
                ", nomeMusculo='" + nomeMusculo + '\'' +
                ", medidaAtual=" + medidaAtual +
                ", medidaAnterior=" + medidaAnterior +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medidas medidas = (Medidas) o;
        return id == medidas.id && Double.compare(medidas.medidaAtual, medidaAtual) == 0 && Double.compare(medidas.medidaAnterior, medidaAnterior) == 0 && Objects.equals(nomeMusculo, medidas.nomeMusculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeMusculo, medidaAtual, medidaAnterior);
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNomeMusculo() {
        return nomeMusculo;
    }

    public void setNomeMusculo(String nomeMusculo) {
        this.nomeMusculo = nomeMusculo;
    }

    public double getMedidaAtual() {
        return medidaAtual;
    }

    public void setMedidaAtual(double medidaAtual) {
        this.medidaAtual = medidaAtual;
    }

    public double getMedidaAnterior() {
        return medidaAnterior;
    }

    public void setMedidaAnterior(double medidaAnterior) {
        this.medidaAnterior = medidaAnterior;
    }
}
