package com.GymTimer.GymTimer.Model.DTOs;


import com.GymTimer.GymTimer.Model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "USUARIODTO")
public class UsuarioDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NOME", length = 150, nullable = false)
    private String nome;

    @Column(name = "DATANASCIMENTO")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataNascimento;

    @Column(name = "TELEFONE", length = 50, nullable = false)
    private String telefone;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.dataNascimento = usuario.getDataNascimento();
        this.telefone = usuario.getTelefone();
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
}
