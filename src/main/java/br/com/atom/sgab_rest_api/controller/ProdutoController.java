package br.com.atom.sgab_rest_api.controller;

import br.com.atom.sgab_rest_api.model.dto.ProdutoDTO;
import br.com.atom.sgab_rest_api.model.entity.Produto;
import br.com.atom.sgab_rest_api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProdutoDTO> findAll(){
        return produtoService.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ProdutoDTO findById(@PathVariable("id") Long id) {
        return produtoService.findById(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ProdutoDTO create(@RequestBody Produto produtoRequest) {
        return produtoService.create(produtoRequest);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ProdutoDTO update(@RequestBody Produto produtoRequest){
        return produtoService.update(produtoRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
