package com.GymTimer.GymTimer.Model;

import com.GymTimer.GymTimer.Model.Enums.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class FichaCorpo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(cascade=CascadeType.ALL)
    private List<Medidas> medidas;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String dataCriacao;

    private double peso;

    private double altura;

    private Sexo sexo;

    private double bodyFat;

    private double imc;

    private String status;

    public FichaCorpo() {
    }

    //APENAS PARA SALVAR A HORA E SETAR O IMC E STATUS
    @PrePersist
    public void prePersist(){
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dataCriacao = dateFormat.format(data);

        this.imc = (this.peso/(this.altura*this.altura));
        setStatus(this.imc);

    }

    public FichaCorpo(double peso, double altura, Sexo sexo, double bodyFat) {
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.bodyFat = bodyFat;
        this.imc = (this.peso/(this.altura*this.altura));
        setStatus(this.imc);
        this.medidas = new ArrayList<Medidas>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FichaCorpo that = (FichaCorpo) o;
        return id == that.id && Double.compare(that.peso, peso) == 0 && Double.compare(that.altura, altura) == 0 && Double.compare(that.bodyFat, bodyFat) == 0 && Double.compare(that.imc, imc) == 0 && Objects.equals(medidas, that.medidas) && Objects.equals(dataCriacao, that.dataCriacao) && sexo == that.sexo && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, medidas, dataCriacao, peso, altura, sexo, bodyFat, imc, status);
    }

    @Override
    public String toString() {
        return "FichaCorpo{" +
                "id=" + id +
                ", medidas=" + medidas +
                ", dataCriacao=" + dataCriacao +
                ", peso=" + peso +
                ", altura=" + altura +
                ", sexo=" + sexo +
                ", bodyFat=" + bodyFat +
                ", imc=" + imc +
                ", status='" + status + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dataCriacao = dateFormat.format(dataCriacao);

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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public double getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(double bodyFat) {
        this.bodyFat = bodyFat;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getStatus() {

        return this.status;

    }

    public void setStatus(double imc) {
        if(imc < 18.5){
            this.status = "MAGREZA";
        } else if(imc >= 18.5 && this.imc <24.9){
            this.status = "NORMAL";
        } else if (imc >=24.9 && this.imc < 29.9) {
            this.status = "SOBREPESO";
        } else if (imc >= 29.9 && this.imc < 39.9) {
            this.status = "OBESIDADE";
        } else if (imc >= 39.9) {
            this.status = "OBESIDADE GRAVE";
        }
    }

    public List<Medidas> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<Medidas> medidas) {
        this.medidas = medidas;
    }

    public void addMedida(Medidas medidas){ this.medidas.add(medidas);}


}
