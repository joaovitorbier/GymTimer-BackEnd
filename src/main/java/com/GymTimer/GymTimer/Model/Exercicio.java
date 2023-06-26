package com.GymTimer.GymTimer.Model;

import com.GymTimer.GymTimer.Model.Enums.CategoriaMuscular;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private CategoriaMuscular categoriaMuscular;
    private int repeticoes;
    private int series;
    private int intervalo;

    public Exercicio() {
    }

    public Exercicio(String nome, CategoriaMuscular categoriaMuscular, int repeticoes, int series, int intervalo) {
        this.nome = nome;
        this.categoriaMuscular = categoriaMuscular;
        this.repeticoes = repeticoes;
        this.series = series;
        this.intervalo = intervalo;
    }

    @Override
    public String toString() {
        return "Exercicio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoriaMuscular=" + categoriaMuscular +
                ", repeticoes=" + repeticoes +
                ", series=" + series +
                ", intervalo=" + intervalo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercicio exercicio = (Exercicio) o;
        return id == exercicio.id && repeticoes == exercicio.repeticoes && series == exercicio.series && intervalo == exercicio.intervalo && Objects.equals(nome, exercicio.nome) && categoriaMuscular == exercicio.categoriaMuscular;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, categoriaMuscular, repeticoes, series, intervalo);
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

    public CategoriaMuscular getCategoriaMuscular() {
        return categoriaMuscular;
    }

    public void setCategoriaMuscular(CategoriaMuscular categoriaMuscular) {
        this.categoriaMuscular = categoriaMuscular;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }
}
