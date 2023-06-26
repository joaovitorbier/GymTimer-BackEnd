package com.GymTimer.GymTimer.Model.Enums;

public enum CategoriaMuscular {

    PEITO("Peito"),
    COSTAS("Costas"),
    OMBROS("Ombros"),
    BICEPS("Bíceps"),
    TRICEPS("Tríceps"),
    ANTEBRACOS("Antebraços"),
    ABDOMEN("Abdômen"),
    GLUTEOS("Glúteos"),
    COXAS("Coxas"),
    PANTURRILHAS("Panturrilhas"),
    CORPO_INTEIRO("Corpo Inteiro");

    private final String nome;

    CategoriaMuscular(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
