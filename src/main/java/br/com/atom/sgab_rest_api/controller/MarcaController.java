package br.com.atom.sgab_rest_api.controller;

import br.com.atom.sgab_rest_api.model.dto.MarcaDTO;
import br.com.atom.sgab_rest_api.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca/v1")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MarcaDTO create (@RequestBody MarcaDTO marcaRequest){
        return marcaService.create(marcaRequest);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MarcaDTO update (@RequestBody MarcaDTO marcaRequest) {
        return marcaService.update(marcaRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MarcaDTO> delete(@PathVariable("id") Long id) {
        marcaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<MarcaDTO> findAll() {
        return marcaService.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MarcaDTO findById(@PathVariable Long id){
        return marcaService.findById(id);
    }

}
