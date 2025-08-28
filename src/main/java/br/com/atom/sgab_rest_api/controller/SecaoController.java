package br.com.atom.sgab_rest_api.controller;

import br.com.atom.sgab_rest_api.model.dto.DepartamentoDTO;
import br.com.atom.sgab_rest_api.model.dto.SecaoDTO;
import br.com.atom.sgab_rest_api.model.entity.Departamento;
import br.com.atom.sgab_rest_api.model.entity.Secao;
import br.com.atom.sgab_rest_api.service.DepartamentoService;
import br.com.atom.sgab_rest_api.service.SecaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secao")
public class SecaoController {

    @Autowired
    private SecaoService secaoService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SecaoDTO create(@Valid @RequestBody Secao secaoRequest) {
        return secaoService.create(secaoRequest);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SecaoDTO update(@RequestBody Secao secaoRequest) {
        return secaoService.update(secaoRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SecaoDTO> delete(@PathVariable("id") Long id) {
        secaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<SecaoDTO> findAll() {
        return secaoService.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SecaoDTO findById(@PathVariable("id") Long id) {
        return secaoService.findById(id);
    }
}
