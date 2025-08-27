package br.com.atom.sgab_rest_api.model.entity;

import br.com.atom.sgab_rest_api.model.enums.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_perfil")
public class Perfil implements Serializable {
     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_perfil", nullable = false)
    private String nome;

    @Column(name = "ds_perfil", nullable = false)
    private String descricao;

    @Enumerated
    @Column(name = "status", nullable = false)
    private Status status;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return Objects.equals(id, perfil.id) && Objects.equals(nome, perfil.nome) && Objects.equals(descricao, perfil.descricao) && status == perfil.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, status);
    }
}
