package br.com.atom.sgab_rest_api.controller;

import br.com.atom.sgab_rest_api.model.dto.CategoriaRequestDTO;
import br.com.atom.sgab_rest_api.model.dto.CategoriaDTO;
import br.com.atom.sgab_rest_api.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria/v1")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CategoriaDTO create(@Valid @RequestBody CategoriaRequestDTO categoriaDTO) {
        return categoriaService.create(categoriaDTO);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CategoriaDTO update(@Valid @RequestBody CategoriaRequestDTO categoriaDTO) {
        return categoriaService.update(categoriaDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CategoriaRequestDTO> delete(@PathVariable("id") Long id) {
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
