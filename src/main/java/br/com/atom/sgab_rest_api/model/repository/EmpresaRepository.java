package br.com.atom.sgab_rest_api.model.repository;

import br.com.atom.sgab_rest_api.model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query("SELECT e FROM Empresa e WHERE e.nomeFantasia LIKE CONCAT('%', ?1, '%') or e.razaoSocial LIKE CONCAT('%', ?1, '%') or e.cnpj LIKE CONCAT('%', ?1, '%')")
    List<Empresa> findByFiltro(String filtro);
}
