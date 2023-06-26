package com.GymTimer.GymTimer.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ListaExercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;

    @ManyToMany(cascade=CascadeType.ALL)
    List<Exercicio> listaDeExercicios;

    public ListaExercicios() {
        this.listaDeExercicios = new ArrayList<Exercicio>();
    }

    public ListaExercicios(String nome) {
        this.nome = nome;
        this.listaDeExercicios = new ArrayList<Exercicio>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaExercicios that = (ListaExercicios) o;
        return id == that.id && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addExercicio(Exercicio exercicio){this.listaDeExercicios.add(exercicio);}

    public void removeExercicio(long id){this.listaDeExercicios.removeIf(exercicio -> exercicio.getId() == id);}

    public List<Exercicio> getListaDeExercicios() {
        return listaDeExercicios;
    }

    public void setListaDeExercicios(List<Exercicio> listaDeExercicios) {
        this.listaDeExercicios = listaDeExercicios;
    }

}
