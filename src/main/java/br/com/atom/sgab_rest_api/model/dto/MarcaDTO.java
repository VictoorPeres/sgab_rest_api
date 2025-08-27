package br.com.atom.sgab_rest_api.model.dto;

import br.com.atom.sgab_rest_api.model.enums.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class MarcaDTO implements Serializable {
     private static final long serialVersionUID = 1L;

    private Long id;
    private String descricao;
    private Status status;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarcaDTO marcaDTO = (MarcaDTO) o;
        return Objects.equals(id, marcaDTO.id) && Objects.equals(descricao, marcaDTO.descricao) && status == marcaDTO.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, status);
    }
}
