package com.GymTimer.GymTimer.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME", length = 150, nullable = false)
    private String nome;

    @Column(name = "DATANASCIMENTO")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date dataNascimento;

    @OneToMany(cascade=CascadeType.ALL)
    private List<FichaCorpo> fichaCorpo = new ArrayList<FichaCorpo>();

    @OneToMany(cascade=CascadeType.ALL)
    private List<FichaExercicio> fichaExercicio = new ArrayList<FichaExercicio>();

    @Column(name = "TELEFONE", length = 50, nullable = false)
    private String telefone;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, Date dataNascimento, String telefone, String email, String senha) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.fichaCorpo = new ArrayList<FichaCorpo>();
        this.fichaExercicio = new ArrayList<FichaExercicio>();

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome) && Objects.equals(dataNascimento, usuario.dataNascimento) && Objects.equals(fichaCorpo, usuario.fichaCorpo) && Objects.equals(fichaExercicio, usuario.fichaExercicio) && Objects.equals(telefone, usuario.telefone) && Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataNascimento, fichaCorpo, fichaExercicio, telefone, email, senha);
    }

    public List<FichaCorpo> getFichaCorpos() {
        return fichaCorpo;
    }


    public void setFichaCorpos(List<FichaCorpo> fichaCorpos) {
        this.fichaCorpo = fichaCorpos;
    }

    public List<FichaExercicio> getFichaExercicio() {
        return fichaExercicio;
    }

    public void addFichaCorpo(FichaCorpo fichaCorpo){this.fichaCorpo.add(fichaCorpo);}

    public void addFichaExercicio(FichaExercicio fichaExercicio){this.fichaExercicio.add(fichaExercicio);}

    public void setFichaExercicio(List<FichaExercicio> fichaExercicio) {
        this.fichaExercicio = fichaExercicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
