package com.GymTimer.GymTimer.Model.DTOs;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="FICHACORPODTO")
public class FichaCorpoDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;


    private double peso;
    private double altura;
    private double bodyFat;

    public FichaCorpoDTO() {
    }

    public FichaCorpoDTO(Long id, double peso, double altura, double bodyFat) {
        this.id = id;
        this.peso = peso;
        this.altura = altura;
        this.bodyFat = bodyFat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(double bodyFat) {
        this.bodyFat = bodyFat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FichaCorpoDTO that = (FichaCorpoDTO) o;
        return Double.compare(that.peso, peso) == 0 && Double.compare(that.altura, altura) == 0 && Double.compare(that.bodyFat, bodyFat) == 0 && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, peso, altura, bodyFat);
    }
}
