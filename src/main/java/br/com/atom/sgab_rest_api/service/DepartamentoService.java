package br.com.atom.sgab_rest_api.service;

import br.com.atom.sgab_rest_api.exception.ResourceNotFoundException;
import br.com.atom.sgab_rest_api.model.dto.DepartamentoDTO;
import br.com.atom.sgab_rest_api.model.entity.Departamento;
import br.com.atom.sgab_rest_api.model.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseListObjects;
import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseObject;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public DepartamentoDTO create(DepartamentoDTO departamentoDTO){
        var entity = parseObject(departamentoDTO, Departamento.class);
        return parseObject(departamentoRepository.save(entity), DepartamentoDTO.class);
    }

    public DepartamentoDTO update(DepartamentoDTO departamentoDTO){
        var entity = departamentoRepository.findById(departamentoDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Departamento não encontrado."));
        entity.setDescricao(departamentoDTO.getDescricao());
        return parseObject((departamentoRepository.save(entity)), DepartamentoDTO.class);
    }

    public void delete(Long id){
        var entity =  departamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Departamento não encontrado."));
        departamentoRepository.delete(entity);
    }

    public List<DepartamentoDTO> findAll() {
        var entity = departamentoRepository.findAll();
        return parseListObjects(entity, DepartamentoDTO.class);
    }

    public DepartamentoDTO findById(Long id) {
        var entity = departamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Departamento não encontrado."));
        return parseObject(entity, DepartamentoDTO.class);
    }
}
