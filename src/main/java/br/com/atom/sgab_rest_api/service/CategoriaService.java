package br.com.atom.sgab_rest_api.service;

import br.com.atom.sgab_rest_api.exception.ResourceNotFoundException;
import br.com.atom.sgab_rest_api.model.dto.CategoriaRequestDTO;
import br.com.atom.sgab_rest_api.model.dto.CategoriaDTO;
import br.com.atom.sgab_rest_api.model.dto.SecaoDTO;
import br.com.atom.sgab_rest_api.model.entity.Categoria;
import br.com.atom.sgab_rest_api.model.entity.Secao;
import br.com.atom.sgab_rest_api.model.repository.CategoriaRepository;
import br.com.atom.sgab_rest_api.model.repository.SecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseObject;
import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseListObjects;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private SecaoRepository secaoRepository;

    public CategoriaDTO create(CategoriaRequestDTO categoriaDTO){
        var entity = parseObject(categoriaDTO, Categoria.class);
        var secao = secaoRepository.findById(categoriaDTO.getIdSecao()).orElseThrow(() -> new ResourceNotFoundException("Seção não encontrada"));

        entity.setSecao(secao);
        entity = categoriaRepository.save(entity);

        return parseObject(entity, CategoriaDTO.class);
    }

    public CategoriaDTO update(CategoriaRequestDTO categoriaDTO){
        var entity = categoriaRepository.findById(categoriaDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada."));
        var secao = secaoRepository.findById(categoriaDTO.getIdSecao()).orElseThrow(() -> new ResourceNotFoundException("Seção não encontrada"));

        entity.setDescricao(categoriaDTO.getDescricao());
        entity.setSecao(secao);
        entity = categoriaRepository.save(entity);

        return parseObject(entity, CategoriaDTO.class);
    }

    public void delete(Long id){
        var entity =  categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoriaRepository.delete(entity);
    }

    public List<CategoriaDTO> findAll() {
        var entity = categoriaRepository.findAll();
        return parseListObjects(entity, CategoriaDTO.class);
    }

    public CategoriaDTO findById(Long id) {
        var entity = categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada."));
        return parseObject(entity, CategoriaDTO.class);
    }
}
