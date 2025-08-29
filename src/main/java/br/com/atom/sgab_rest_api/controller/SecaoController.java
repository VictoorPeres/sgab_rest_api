package br.com.atom.sgab_rest_api.controller;

import br.com.atom.sgab_rest_api.model.dto.DepartamentoDTO;
import br.com.atom.sgab_rest_api.model.dto.SecaoDTO;
import br.com.atom.sgab_rest_api.model.dto.SecaoRequestDTO;
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
@RequestMapping("/api/secao/v1")
public class SecaoController {

    @Autowired
    private SecaoService secaoService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SecaoDTO create(@Valid @RequestBody SecaoRequestDTO secaoRequestDTO) {
        return secaoService.create(secaoRequestDTO);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SecaoDTO update(@RequestBody SecaoRequestDTO secaoRequestDTO) {
        return secaoService.update(secaoRequestDTO);
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
