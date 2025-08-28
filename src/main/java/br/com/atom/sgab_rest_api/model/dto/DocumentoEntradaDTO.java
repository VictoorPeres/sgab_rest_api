package br.com.atom.sgab_rest_api.model.dto;

import br.com.atom.sgab_rest_api.model.entity.*;
import br.com.atom.sgab_rest_api.model.enums.StatusDocumentoEntrada;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DocumentoEntradaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull(message = "Informe o item que foi recebido")
    private List<ItemDocumentoEntrada> itens = new ArrayList<>();

    @NotBlank(message = "A descrição é obrigatória.")
    private String descricao;

    @NotBlank(message = "Selecione o item que foi emprestado")
    private String snProdutoEmprestado;

    @NotBlank(message = "O número de série do item emprestado é obrigatório")
    private String nrSerieEmprestimo;

    private String dtAbertura;

    @Enumerated
    private StatusDocumentoEntrada statusDocumento;

    @NotNull(message = "Selecione um produto para empréstimo")
    private Produto produtoEmprestado;

    @NotBlank(message = "A previsão de saída é obrigatória")
    private String dtPrevisaoSaida;

    private Cliente cliente;

    private Usuario usuario;

    private Empresa empresa;

    private List<DocumentoSaida> documentoSaidaList = new ArrayList<>();

    private byte[] relatorioSinistro;

    private byte[] relatorioSinistroResumo;

    private String dtFechamento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Informe o item que foi recebido") List<ItemDocumentoEntrada> getItens() {
        return itens;
    }

    public void setItens(@NotNull(message = "Informe o item que foi recebido") List<ItemDocumentoEntrada> itens) {
        this.itens = itens;
    }

    public @NotBlank(message = "A descrição é obrigatória.") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "A descrição é obrigatória.") String descricao) {
        this.descricao = descricao;
    }

    public @NotBlank(message = "Selecione o item que foi emprestado") String getSnProdutoEmprestado() {
        return snProdutoEmprestado;
    }

    public void setSnProdutoEmprestado(@NotBlank(message = "Selecione o item que foi emprestado") String snProdutoEmprestado) {
        this.snProdutoEmprestado = snProdutoEmprestado;
    }

    public @NotBlank(message = "O número de série do item emprestado é obrigatório") String getNrSerieEmprestimo() {
        return nrSerieEmprestimo;
    }

    public void setNrSerieEmprestimo(@NotBlank(message = "O número de série do item emprestado é obrigatório") String nrSerieEmprestimo) {
        this.nrSerieEmprestimo = nrSerieEmprestimo;
    }

    public String getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(String dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public StatusDocumentoEntrada getStatusDocumento() {
        return statusDocumento;
    }

    public void setStatusDocumento(StatusDocumentoEntrada statusDocumento) {
        this.statusDocumento = statusDocumento;
    }

    public @NotNull(message = "Selecione um produto para empréstimo") Produto getProdutoEmprestado() {
        return produtoEmprestado;
    }

    public void setProdutoEmprestado(@NotNull(message = "Selecione um produto para empréstimo") Produto produtoEmprestado) {
        this.produtoEmprestado = produtoEmprestado;
    }

    public @NotBlank(message = "A previsão de saída é obrigatória") String getDtPrevisaoSaida() {
        return dtPrevisaoSaida;
    }

    public void setDtPrevisaoSaida(@NotBlank(message = "A previsão de saída é obrigatória") String dtPrevisaoSaida) {
        this.dtPrevisaoSaida = dtPrevisaoSaida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<DocumentoSaida> getDocumentoSaidaList() {
        return documentoSaidaList;
    }

    public void setDocumentoSaidaList(List<DocumentoSaida> documentoSaidaList) {
        this.documentoSaidaList = documentoSaidaList;
    }

    public byte[] getRelatorioSinistro() {
        return relatorioSinistro;
    }

    public void setRelatorioSinistro(byte[] relatorioSinistro) {
        this.relatorioSinistro = relatorioSinistro;
    }

    public byte[] getRelatorioSinistroResumo() {
        return relatorioSinistroResumo;
    }

    public void setRelatorioSinistroResumo(byte[] relatorioSinistroResumo) {
        this.relatorioSinistroResumo = relatorioSinistroResumo;
    }

    public String getDtFechamento() {
        return dtFechamento;
    }

    public void setDtFechamento(String dtFechamento) {
        this.dtFechamento = dtFechamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentoEntradaDTO that = (DocumentoEntradaDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(itens, that.itens) && Objects.equals(descricao, that.descricao) && Objects.equals(snProdutoEmprestado, that.snProdutoEmprestado) && Objects.equals(nrSerieEmprestimo, that.nrSerieEmprestimo) && Objects.equals(dtAbertura, that.dtAbertura) && Objects.equals(dtFechamento, that.dtFechamento) && Objects.equals(dtPrevisaoSaida, that.dtPrevisaoSaida) && statusDocumento == that.statusDocumento && Objects.equals(produtoEmprestado, that.produtoEmprestado) && Objects.equals(cliente, that.cliente) && Objects.equals(usuario, that.usuario) && Objects.equals(empresa, that.empresa) && Objects.equals(documentoSaidaList, that.documentoSaidaList) && Objects.deepEquals(relatorioSinistro, that.relatorioSinistro) && Objects.deepEquals(relatorioSinistroResumo, that.relatorioSinistroResumo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itens, descricao, snProdutoEmprestado, nrSerieEmprestimo, dtAbertura, dtFechamento, dtPrevisaoSaida, statusDocumento, produtoEmprestado, cliente, usuario, empresa, documentoSaidaList, Arrays.hashCode(relatorioSinistro), Arrays.hashCode(relatorioSinistroResumo));
    }
}
