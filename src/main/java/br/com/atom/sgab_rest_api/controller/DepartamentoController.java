package br.com.atom.sgab_rest_api.controller;

import br.com.atom.sgab_rest_api.model.dto.CategoriaDTO;
import br.com.atom.sgab_rest_api.model.dto.DepartamentoDTO;
import br.com.atom.sgab_rest_api.model.entity.Categoria;
import br.com.atom.sgab_rest_api.model.entity.Departamento;
import br.com.atom.sgab_rest_api.service.CategoriaService;
import br.com.atom.sgab_rest_api.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DepartamentoDTO create(@Valid @RequestBody Departamento departamentoRequest) {
        return departamentoService.create(departamentoRequest);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DepartamentoDTO update(@RequestBody Departamento departamentoRequest) {
        return departamentoService.update(departamentoRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DepartamentoDTO> delete(@PathVariable("id") Long id) {
        departamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<DepartamentoDTO> findAll() {
        return departamentoService.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DepartamentoDTO findById(@PathVariable("id") Long id) {
        return departamentoService.findById(id);
    }
}
