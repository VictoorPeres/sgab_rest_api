package br.com.atom.sgab_rest_api.controller;

import br.com.atom.sgab_rest_api.model.dto.CategoriaDTO;
import br.com.atom.sgab_rest_api.model.entity.Categoria;
import br.com.atom.sgab_rest_api.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CategoriaDTO create(@Valid @RequestBody Categoria categoriaRequest) {
        return categoriaService.create(categoriaRequest);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CategoriaDTO update(@RequestBody Categoria categoriaRequest) {
        return categoriaService.update(categoriaRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> delete(@PathVariable("id") Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<CategoriaDTO> findAll() {
        return categoriaService.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CategoriaDTO findById(@PathVariable("id") Long id) {
        return categoriaService.findById(id);
    }
}
