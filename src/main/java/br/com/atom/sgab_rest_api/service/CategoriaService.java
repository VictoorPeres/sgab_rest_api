package br.com.atom.sgab_rest_api.service;

import br.com.atom.sgab_rest_api.exception.ResourceNotFoundException;
import br.com.atom.sgab_rest_api.model.dto.CategoriaDTO;
import br.com.atom.sgab_rest_api.model.entity.Categoria;
import br.com.atom.sgab_rest_api.model.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseObject;
import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseListObjects;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaDTO create(Categoria categoria){
        return parseObject(categoriaRepository.save(categoria), CategoriaDTO.class);
    }

    public CategoriaDTO update(Categoria categoria){
        var entity = categoriaRepository.findById(categoria.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada."));
        entity.setDescricao(categoria.getDescricao());
        entity.setSecao(categoria.getSecao());
        return parseObject((categoriaRepository.save(categoria)), CategoriaDTO.class);
    }

    public void delete(Long id){
        var entity =  categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoriaRepository.delete(entity);
    }

    public List<CategoriaDTO> findAll() {
        var entity = categoriaRepository.findAll();
        if(entity.isEmpty()) {
            throw new ResourceNotFoundException("Nenhuma categoria encontrada.");
        }
        return parseListObjects(entity, CategoriaDTO.class);
    }

    public CategoriaDTO findById(Long id) {
        var entity = categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada."));
        return parseObject(entity, CategoriaDTO.class);
    }
}
