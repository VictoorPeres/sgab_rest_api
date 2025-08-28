package br.com.atom.sgab_rest_api.model.repository;

import br.com.atom.sgab_rest_api.model.entity.Departamento;
import br.com.atom.sgab_rest_api.model.entity.Secao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecaoRepository extends JpaRepository<Secao, Long> {
}
