package br.com.atom.sgab_rest_api.model.dto;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class ProdutoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String codigoBarras;
    private Long codigoFabricante;

    private String descricao;
    private String categoria;
    private String segmento;
    private String marca;
    private String modelo;

    private Double valorCusto;
    private Double valorVenda;

    private Double peso;
    private Double altura;
    private Double largura;
    private Double profundidade;

    private String observacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Long getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigoFabricante(Long codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
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

    public Double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoDTO produto)) return false;
        return Objects.equals(id, produto.id) && Objects.equals(codigoBarras, produto.codigoBarras) && Objects.equals(codigoFabricante, produto.codigoFabricante) && Objects.equals(descricao, produto.descricao) && Objects.equals(categoria, produto.categoria) && Objects.equals(segmento, produto.segmento) && Objects.equals(marca, produto.marca) && Objects.equals(modelo, produto.modelo) && Objects.equals(valorCusto, produto.valorCusto) && Objects.equals(valorVenda, produto.valorVenda) && Objects.equals(peso, produto.peso) && Objects.equals(altura, produto.altura) && Objects.equals(largura, produto.largura) && Objects.equals(profundidade, produto.profundidade) && Objects.equals(observacoes, produto.observacoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoBarras, codigoFabricante, descricao, categoria, segmento, marca, modelo, valorCusto, valorVenda, peso, altura, largura, profundidade, observacoes);
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" +
                "id=" + id +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", codigoFabricante=" + codigoFabricante +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", segmento='" + segmento + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", valorCusto=" + valorCusto +
                ", valorVenda=" + valorVenda +
                ", peso=" + peso +
                ", altura=" + altura +
                ", largura=" + largura +
                ", profundidade=" + profundidade +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
