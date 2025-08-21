package br.com.atom.sgab_rest_api.model.dto;


import java.io.Serializable;
import java.util.Objects;

public class ProdutoCreateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String descricao;
    private String marca;
    private String modelo;
    private Double peso;
    private String observacoes;

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoCreateDTO that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(marca, that.marca) && Objects.equals(modelo, that.modelo) && Objects.equals(peso, that.peso) && Objects.equals(observacoes, that.observacoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, marca, modelo, peso, observacoes);
    }
}
