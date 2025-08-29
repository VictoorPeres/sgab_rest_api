package br.com.atom.sgab_rest_api.controller;

import br.com.atom.sgab_rest_api.model.dto.AcessoDTO;
import br.com.atom.sgab_rest_api.model.entity.Acesso;
import br.com.atom.sgab_rest_api.service.AcessoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acesso/v1")
public class AcessoController {

    @Autowired
    private AcessoService acessoService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AcessoDTO create(@Valid @RequestBody AcessoDTO acessoDTO){
        return acessoService.create(acessoDTO);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AcessoDTO update(@Valid @RequestBody AcessoDTO acessoDTO){
        return acessoService.update(acessoDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AcessoDTO> delete(@PathVariable("id") Long id){
        acessoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<AcessoDTO> findAll(){
        return acessoService.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AcessoDTO findById(@PathVariable("id") Long id){
        return acessoService.findById(id);
    }
}
