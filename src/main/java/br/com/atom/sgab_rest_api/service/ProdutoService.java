package br.com.atom.sgab_rest_api.service;

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

    public ProdutoDTO create(Produto produto) {
        return parseObject(produtoRepository.save(produto), ProdutoDTO.class);
    }

    public ProdutoDTO update(Produto produto) {
            return parseObject(produtoRepository.save(produto), ProdutoDTO.class);
    }

    public void delete(Long id) {
        ProdutoDTO produtoDTO = findById(id);
        if(produtoDTO != null){
            var entity = parseObject(produtoDTO, Produto.class);
            produtoRepository.delete(entity);
        }
    }

    public ProdutoDTO findById(Long id) {

        var entity =  produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente not found"));
        return parseObject(entity, ProdutoDTO.class);
    }

    public List<ProdutoDTO> findByFiltro(String filtro) {
        var entity = produtoRepository.findByFiltro(filtro);
        return parseListObjects(entity, ProdutoDTO.class);
    }

    public List<ProdutoDTO> findAll() {
        var entity = produtoRepository.findAll();
        return parseListObjects(entity, ProdutoDTO.class);
    }

}
