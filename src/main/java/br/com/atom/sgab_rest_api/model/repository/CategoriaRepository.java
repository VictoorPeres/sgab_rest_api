package br.com.atom.sgab_rest_api.model.repository;

import br.com.atom.sgab_rest_api.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
