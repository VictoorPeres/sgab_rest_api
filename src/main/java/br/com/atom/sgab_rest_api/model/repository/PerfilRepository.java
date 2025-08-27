package br.com.atom.sgab_rest_api.model.repository;

import br.com.atom.sgab_rest_api.model.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
