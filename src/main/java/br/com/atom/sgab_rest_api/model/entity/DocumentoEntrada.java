package br.com.atom.sgab_rest_api.model.entity;

import br.com.atom.sgab_rest_api.model.enums.StatusDocumentoEntrada;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_documento_entrada")
public class DocumentoEntrada implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "documentoEntrada", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDocumentoEntrada> itens = new ArrayList<>();

    @Column(name="ds_documento_entrada", nullable = false)
    private String descricao;

    @Column(name = "sn_produto_emprestado")
    private String snProdutoEmprestado;

    @Column(name = "nr_serie_emprestimo")
    private String nrSerieEmprestimo;

    @Column(name = "dt_abertura", nullable = false)
    private String dtAbertura;

    @Column(name = "dt_fechamento")
    private String dtFechamento;

    @Column(name = "dt_previsao_saida", nullable = false)
    private String dtPrevisaoSaida;

    @Enumerated
    @Column(name = "status_documento", nullable = false)
    private StatusDocumentoEntrada statusDocumento;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_produto_emprestado")
    private Produto produtoEmprestado;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToMany(mappedBy = "documentoEntrada", fetch = FetchType.LAZY)
    private List<DocumentoSaida> documentoSaidaList = new ArrayList<>();

    @Column(name = "bi_relatorio_sinistro")
    private byte[] relatorioSinistro;

    @Column(name = "bi_relatorio_sinistro_resumo")
    private byte[] relatorioSinistroResumo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemDocumentoEntrada> getItens() {
        return itens;
    }

    public void setItens(List<ItemDocumentoEntrada> itens) {
        this.itens = itens;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSnProdutoEmprestado() {
        return snProdutoEmprestado;
    }

    public void setSnProdutoEmprestado(String snProdutoEmprestado) {
        this.snProdutoEmprestado = snProdutoEmprestado;
    }

    public String getNrSerieEmprestimo() {
        return nrSerieEmprestimo;
    }

    public void setNrSerieEmprestimo(String nrSerieEmprestimo) {
        this.nrSerieEmprestimo = nrSerieEmprestimo;
    }

    public String getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(String dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public String getDtFechamento() {
        return dtFechamento;
    }

    public void setDtFechamento(String dtFechamento) {
        this.dtFechamento = dtFechamento;
    }

    public String getDtPrevisaoSaida() {
        return dtPrevisaoSaida;
    }

    public void setDtPrevisaoSaida(String dtPrevisaoSaida) {
        this.dtPrevisaoSaida = dtPrevisaoSaida;
    }

    public StatusDocumentoEntrada getStatusDocumento() {
        return statusDocumento;
    }

    public void setStatusDocumento(StatusDocumentoEntrada statusDocumento) {
        this.statusDocumento = statusDocumento;
    }

    public Produto getProdutoEmprestado() {
        return produtoEmprestado;
    }

    public void setProdutoEmprestado(Produto produtoEmprestado) {
        this.produtoEmprestado = produtoEmprestado;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentoEntrada that = (DocumentoEntrada) o;
        return Objects.equals(id, that.id) && Objects.equals(itens, that.itens) && Objects.equals(descricao, that.descricao) && Objects.equals(snProdutoEmprestado, that.snProdutoEmprestado) && Objects.equals(nrSerieEmprestimo, that.nrSerieEmprestimo) && Objects.equals(dtAbertura, that.dtAbertura) && Objects.equals(dtFechamento, that.dtFechamento) && Objects.equals(dtPrevisaoSaida, that.dtPrevisaoSaida) && statusDocumento == that.statusDocumento && Objects.equals(produtoEmprestado, that.produtoEmprestado) && Objects.equals(cliente, that.cliente) && Objects.equals(usuario, that.usuario) && Objects.equals(empresa, that.empresa) && Objects.equals(documentoSaidaList, that.documentoSaidaList) && Objects.deepEquals(relatorioSinistro, that.relatorioSinistro) && Objects.deepEquals(relatorioSinistroResumo, that.relatorioSinistroResumo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itens, descricao, snProdutoEmprestado, nrSerieEmprestimo, dtAbertura, dtFechamento, dtPrevisaoSaida, statusDocumento, produtoEmprestado, cliente, usuario, empresa, documentoSaidaList, Arrays.hashCode(relatorioSinistro), Arrays.hashCode(relatorioSinistroResumo));
    }
}
