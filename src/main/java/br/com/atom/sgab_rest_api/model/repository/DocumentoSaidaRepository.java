package br.com.atom.sgab_rest_api.model.repository;

import br.com.atom.sgab_rest_api.model.entity.DocumentoSaida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoSaidaRepository extends JpaRepository<DocumentoSaida, Long> {
}
