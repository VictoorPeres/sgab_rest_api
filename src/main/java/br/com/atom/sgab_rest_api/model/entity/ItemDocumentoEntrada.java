package br.com.atom.sgab_rest_api.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_item_documento_entrada")
public class ItemDocumentoEntrada implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_documento_entrada")
    private DocumentoEntrada documentoEntrada;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(name = "nr_serie", nullable = false)
    private String numeroSerie;

    @Column(name = "dt_compra", nullable = false)
    private Date dataCompra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DocumentoEntrada getDocumentoEntrada() {
        return documentoEntrada;
    }

    public void setDocumentoEntrada(DocumentoEntrada documentoEntrada) {
        this.documentoEntrada = documentoEntrada;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDocumentoEntrada that = (ItemDocumentoEntrada) o;
        return Objects.equals(id, that.id) && Objects.equals(documentoEntrada, that.documentoEntrada) && Objects.equals(produto, that.produto) && Objects.equals(numeroSerie, that.numeroSerie) && Objects.equals(dataCompra, that.dataCompra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentoEntrada, produto, numeroSerie, dataCompra);
    }
}
