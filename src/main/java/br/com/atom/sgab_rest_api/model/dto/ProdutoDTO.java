package br.com.atom.sgab_rest_api.model.dto;


import br.com.atom.sgab_rest_api.model.entity.Categoria;
import br.com.atom.sgab_rest_api.model.entity.Marca;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class ProdutoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "A descrição é obrigatória.")
    private String descricao;
    @NotBlank(message = "O modelo é obrigatório.")
    private String modelo;
    @NotNull(message = "O peso é obrigatório.")
    private Double peso;
    private Double altura;
    private Double largura;
    private Double profundidade;
    private String observacoes;
    @NotNull(message = "A categoria do produto é obrigatória.")
    private Categoria categoriaProduto;
    @NotNull(message = "A marca do produto é obrigatória.")
    private Marca marca;


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

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Categoria getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(Categoria categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoDTO that = (ProdutoDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(modelo, that.modelo) && Objects.equals(peso, that.peso) && Objects.equals(altura, that.altura) && Objects.equals(largura, that.largura) && Objects.equals(profundidade, that.profundidade) && Objects.equals(observacoes, that.observacoes) && Objects.equals(categoriaProduto, that.categoriaProduto) && Objects.equals(marca, that.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, modelo, peso, altura, largura, profundidade, observacoes, categoriaProduto, marca);
    }
}
