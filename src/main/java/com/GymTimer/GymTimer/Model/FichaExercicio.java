package com.GymTimer.GymTimer.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.CascadeType.*;

@Entity
public class FichaExercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String objetivo;
    private double metaPeso;
    private double metaBodyFat;

    @ManyToMany(cascade= ALL)
    private List<ListaExercicios> listasDeExercicios;


    public FichaExercicio() {
        this.listasDeExercicios = new ArrayList<ListaExercicios>();
    }

    public FichaExercicio(String objetivo, double metaPeso, double metaBodyFat) {
        this.objetivo = objetivo;
        this.metaPeso = metaPeso;
        this.metaBodyFat = metaBodyFat;
        this.listasDeExercicios = new ArrayList<ListaExercicios>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FichaExercicio that = (FichaExercicio) o;
        return id == that.id && Double.compare(that.metaPeso, metaPeso) == 0 && Double.compare(that.metaBodyFat, metaBodyFat) == 0 && Objects.equals(objetivo, that.objetivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, objetivo, metaPeso, metaBodyFat);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public double getMetaPeso() {
        return metaPeso;
    }

    public void setMetaPeso(double metaPeso) {
        this.metaPeso = metaPeso;
    }

    public double getMetaBodyFat() {
        return metaBodyFat;
    }

    public void setMetaBodyFat(double metaBodyFat) {
        this.metaBodyFat = metaBodyFat;
    }

    public  void addListaDeExercicio(ListaExercicios listaExercicios){this.listasDeExercicios.add(listaExercicios);}

    //public void removeListaDeExercicio(Long id){this.listasDeExercicios.get(id).removeIf(exercicio -> exercicio.getId() == id);}

    public List<ListaExercicios> getListasDeExercicios() {
        return listasDeExercicios;
    }

    public void setListasDeExercicios(List<ListaExercicios> listasDeExercicios) {
        this.listasDeExercicios = listasDeExercicios;
    }


}
