package br.com.atom.sgab_rest_api.model.repository;

import br.com.atom.sgab_rest_api.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
