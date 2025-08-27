package br.com.atom.sgab_rest_api.model.repository;

import br.com.atom.sgab_rest_api.model.entity.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AcessoRepository extends JpaRepository<Acesso, Long> {

}
