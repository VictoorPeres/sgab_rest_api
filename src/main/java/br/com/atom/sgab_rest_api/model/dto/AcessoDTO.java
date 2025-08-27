package br.com.atom.sgab_rest_api.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Objects;

public class AcessoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "O campo NOME não pode ser vazio")
    private String nome;

    @NotBlank(message = "O campo DESCRIÇÃO não pode ser vazio")
    private String descricao;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcessoDTO acesso = (AcessoDTO) o;
        return Objects.equals(id, acesso.id) && Objects.equals(nome, acesso.nome) && Objects.equals(descricao, acesso.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao);
    }
}
