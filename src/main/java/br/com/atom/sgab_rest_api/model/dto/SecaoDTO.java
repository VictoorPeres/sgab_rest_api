package br.com.atom.sgab_rest_api.model.dto;

import br.com.atom.sgab_rest_api.model.entity.Departamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class SecaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
    @NotNull(message = "O departamento é obrigatório")
    private Departamento departamento;

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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecaoDTO secao = (SecaoDTO) o;
        return Objects.equals(id, secao.id) && Objects.equals(descricao, secao.descricao) && Objects.equals(departamento, secao.departamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, departamento);
    }
}
