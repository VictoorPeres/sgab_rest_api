package br.com.atom.sgab_rest_api.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_perfil_acesso")
public class PerfilAcesso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_acesso")
    private Acesso acesso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerfilAcesso that = (PerfilAcesso) o;
        return Objects.equals(id, that.id) && Objects.equals(perfil, that.perfil) && Objects.equals(acesso, that.acesso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, perfil, acesso);
    }
}
