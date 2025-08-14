package br.com.atom.sgab_rest_api.model.repository;

import br.com.atom.sgab_rest_api.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.cpf = ?1")
    Cliente findByCpf(String cpf);

    @Query("SELECT c FROM Cliente c WHERE c.nome LIKE CONCAT('%', ?1, '%')")
    List<Cliente> findByFiltro(String filtro);
}
