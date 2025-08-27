package br.com.atom.sgab_rest_api.model.entity;

import br.com.atom.sgab_rest_api.model.enums.TipoEmpresa;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_empresa")
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nm_fantasia", nullable = false)
    private String nomeFantasia;

    @Column(name="razao_social", nullable = false)
    private String razaoSocial;

    @Column(name="cnpj", nullable = false)
    private String cnpj;

    private String email;

    @Column(name="nr_telefone", nullable = false)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "id_distribuidora")
    private Empresa empresa;

    @Enumerated
    @Column(name="tp_empresa", nullable = false)
    private TipoEmpresa tipoEmpresa;

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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
        Empresa empresa1 = (Empresa) o;
        return Objects.equals(id, empresa1.id) && Objects.equals(nomeFantasia, empresa1.nomeFantasia) && Objects.equals(razaoSocial, empresa1.razaoSocial) && Objects.equals(cnpj, empresa1.cnpj) && Objects.equals(email, empresa1.email) && Objects.equals(telefone, empresa1.telefone) && Objects.equals(empresa, empresa1.empresa) && tipoEmpresa == empresa1.tipoEmpresa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeFantasia, razaoSocial, cnpj, email, telefone, empresa, tipoEmpresa);
    }
}
