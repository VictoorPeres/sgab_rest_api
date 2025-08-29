package br.com.atom.sgab_rest_api.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "A descrição é obrigatória.")
    private String descricao;
    @NotNull(message = "A seção é obrigatória")
    private SecaoDTO secao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public SecaoDTO getSecao() {
        return secao;
    }

    public void setSecao(SecaoDTO secao) {
        this.secao = secao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaDTO that = (CategoriaDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(secao, that.secao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, secao);
    }
}
