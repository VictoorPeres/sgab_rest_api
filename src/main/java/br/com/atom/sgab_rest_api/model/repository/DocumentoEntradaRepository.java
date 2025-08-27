package br.com.atom.sgab_rest_api.model.repository;

import br.com.atom.sgab_rest_api.model.entity.DocumentoEntrada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoEntradaRepository extends JpaRepository<DocumentoEntrada, Long> {
}
