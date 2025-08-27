package br.com.atom.sgab_rest_api.model.repository;

import br.com.atom.sgab_rest_api.model.dto.MarcaDTO;
import br.com.atom.sgab_rest_api.model.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    @Query("SELECT m FROM Marca m WHERE m.descricao LIKE %?1%")
    MarcaDTO findByFiltro(String filtro);
}
