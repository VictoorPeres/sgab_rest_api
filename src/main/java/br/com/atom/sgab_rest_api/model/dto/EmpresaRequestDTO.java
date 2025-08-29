package br.com.atom.sgab_rest_api.model.dto;

import br.com.atom.sgab_rest_api.model.enums.TipoEmpresa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.logging.Log;

import java.io.Serializable;
import java.util.Objects;

public class EmpresaRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "O nome fantasia é obrigatório")
    private String nomeFantasia;
    @NotBlank(message = "A razão social é obrigatória")
    private String razaoSocial;
    @NotBlank(message = "O CNPJ é obrigatório")
    private String cnpj;
    @NotBlank(message = "O email é obrigatório")
    private String email;
    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;
    @NotNull(message = "O tipo da empresa é obrigatório")
    private TipoEmpresa tipoEmpresa;
    private Long idDistribuidora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getIdDistribuidora() {
        return idDistribuidora;
    }

    public void setIdDistribuidora(Long idDistribuidora) {
        this.idDistribuidora = idDistribuidora;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaRequestDTO that = (EmpresaRequestDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(nomeFantasia, that.nomeFantasia) && Objects.equals(razaoSocial, that.razaoSocial) && Objects.equals(cnpj, that.cnpj) && Objects.equals(email, that.email) && Objects.equals(telefone, that.telefone) && tipoEmpresa == that.tipoEmpresa && Objects.equals(idDistribuidora, that.idDistribuidora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeFantasia, razaoSocial, cnpj, email, telefone, tipoEmpresa, idDistribuidora);
    }
}
