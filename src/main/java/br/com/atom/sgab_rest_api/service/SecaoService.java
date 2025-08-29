package br.com.atom.sgab_rest_api.service;

import br.com.atom.sgab_rest_api.exception.ResourceNotFoundException;
import br.com.atom.sgab_rest_api.model.dto.DepartamentoDTO;
import br.com.atom.sgab_rest_api.model.dto.SecaoDTO;
import br.com.atom.sgab_rest_api.model.dto.SecaoRequestDTO;
import br.com.atom.sgab_rest_api.model.entity.Departamento;
import br.com.atom.sgab_rest_api.model.entity.Secao;
import br.com.atom.sgab_rest_api.model.repository.DepartamentoRepository;
import br.com.atom.sgab_rest_api.model.repository.SecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseListObjects;
import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseObject;

@Service
public class SecaoService {

    @Autowired
    private SecaoRepository secaoRepository;
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public SecaoDTO create(SecaoRequestDTO secaoRequestDTO){
        var entity = parseObject(secaoRequestDTO, Secao.class);
        var departamento = departamentoRepository.findById(secaoRequestDTO.getIdDepartamento()).orElseThrow(() ->  new ResourceNotFoundException("Departamento não encontrado"));

        entity.setDepartamento(departamento);
        entity = secaoRepository.save(entity);
        return parseObject(entity, SecaoDTO.class);
    }

    public SecaoDTO update(SecaoRequestDTO secaoRequestDTO){
        var entity = secaoRepository.findById(secaoRequestDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Seção não encontrada."));
        var departamento = departamentoRepository.findById(secaoRequestDTO.getIdDepartamento()).orElseThrow(() ->  new ResourceNotFoundException("Departamento não encontrado"));

        entity.setDescricao(secaoRequestDTO.getDescricao());
        entity.setDepartamento(departamento);
        entity = secaoRepository.save(entity);

        return parseObject(entity, SecaoDTO.class);
    }

    public void delete(Long id){
        var entity =  secaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Seção não encontrada."));
        secaoRepository.delete(entity);
    }

    public List<SecaoDTO> findAll() {
        var entity = secaoRepository.findAll();
        return parseListObjects(entity, SecaoDTO.class);
    }

    public SecaoDTO findById(Long id) {
        var entity = secaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Seção não encontrada."));
        return parseObject(entity, SecaoDTO.class);
    }
}
