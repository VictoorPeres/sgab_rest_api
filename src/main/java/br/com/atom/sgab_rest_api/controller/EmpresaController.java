package br.com.atom.sgab_rest_api.controller;

import br.com.atom.sgab_rest_api.model.dto.EmpresaDTO;
import br.com.atom.sgab_rest_api.model.dto.EmpresaRequestDTO;
import br.com.atom.sgab_rest_api.model.entity.Empresa;
import br.com.atom.sgab_rest_api.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresa/v1")
public class EmpresaController{

    @Autowired
    private EmpresaService empresaService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public EmpresaDTO create(@Valid @RequestBody EmpresaRequestDTO empresaRequestDTO) {
        return empresaService.create(empresaRequestDTO);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public EmpresaDTO update(@Valid @RequestBody EmpresaRequestDTO empresaRequestDTO) {
        return empresaService.update(empresaRequestDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EmpresaDTO>delete(@PathVariable("id") Long id){
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<EmpresaDTO> findAll(){
        return empresaService.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public EmpresaDTO findById(@PathVariable("id") Long id){
        return empresaService.findById(id);
    }

    @GetMapping(value = "/consulta/{filtro}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<EmpresaDTO> findByFiltro(@PathVariable("filtro") String filtro){
        return empresaService.findByFiltro(filtro);
    }
}
