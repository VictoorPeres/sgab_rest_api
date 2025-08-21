package br.com.atom.sgab_rest_api.service;

import br.com.atom.sgab_rest_api.exception.ResourceNotFoundException;
import br.com.atom.sgab_rest_api.model.dto.ProdutoCreateDTO;
import br.com.atom.sgab_rest_api.model.dto.ProdutoDTO;
import br.com.atom.sgab_rest_api.model.entity.Produto;
import br.com.atom.sgab_rest_api.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseListObjects;
import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseObject;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoCreateDTO create(Produto produto) {
        return parseObject(produtoRepository.save(produto), ProdutoCreateDTO.class);
    }

    public ProdutoDTO update(Produto produtoRequest) {
            Produto produto = produtoRepository.findById(produtoRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado."));
            return parseObject(produtoRepository.save(produto), ProdutoDTO.class);
    }

    public void delete(Long id) {
            var entity = produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado."));
            produtoRepository.delete(entity);

    }

    public ProdutoDTO findById(Long id) {

        var entity =  produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado."));
        return parseObject(entity, ProdutoDTO.class);
    }

    public List<ProdutoDTO> findByFiltro(String filtro) {
        var entity = produtoRepository.findByFiltro(filtro);
        if(entity.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum produto encontrado com o filtro: " + filtro);
        }
        return parseListObjects(entity, ProdutoDTO.class);
    }

    public List<ProdutoDTO> findAll() {
        var entity = produtoRepository.findAll();
        if(entity.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum produto encontrado.");
        }
        return parseListObjects(entity, ProdutoDTO.class);
    }

}
