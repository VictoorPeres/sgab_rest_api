package br.com.atom.sgab_rest_api.model.dto;

import br.com.atom.sgab_rest_api.model.entity.DocumentoEntrada;
import br.com.atom.sgab_rest_api.model.entity.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class DocumentoSaidaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "A descrição é obrigatória.")
    private String descricao;

    private String dataAcao;

    private Usuario usuario;

    private DocumentoEntrada documentoEntrada;

    private String nomeAnexo;

    private byte[] anexo;

    private String tipoAnexo;

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

    public String getDataAcao() {
        return dataAcao;
    }

    public void setDataAcao(String dataAcao) {
        this.dataAcao = dataAcao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public DocumentoEntrada getDocumentoEntrada() {
        return documentoEntrada;
    }

    public void setDocumentoEntrada(DocumentoEntrada documentoEntrada) {
        this.documentoEntrada = documentoEntrada;
    }

    public String getNomeAnexo() {
        return nomeAnexo;
    }

    public void setNomeAnexo(String nomeAnexo) {
        this.nomeAnexo = nomeAnexo;
    }

    public byte[] getAnexo() {
        return anexo;
    }

    public void setAnexo(byte[] anexo) {
        this.anexo = anexo;
    }

    public String getTipoAnexo() {
        return tipoAnexo;
    }

    public void setTipoAnexo(String tipoAnexo) {
        this.tipoAnexo = tipoAnexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentoSaidaDTO that = (DocumentoSaidaDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(dataAcao, that.dataAcao) && Objects.equals(usuario, that.usuario) && Objects.equals(documentoEntrada, that.documentoEntrada) && Objects.equals(nomeAnexo, that.nomeAnexo) && Objects.deepEquals(anexo, that.anexo) && Objects.equals(tipoAnexo, that.tipoAnexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, dataAcao, usuario, documentoEntrada, nomeAnexo, Arrays.hashCode(anexo), tipoAnexo);
    }
}
