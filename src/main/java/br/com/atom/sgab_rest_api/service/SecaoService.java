package br.com.atom.sgab_rest_api.service;

import br.com.atom.sgab_rest_api.exception.ResourceNotFoundException;
import br.com.atom.sgab_rest_api.model.dto.DepartamentoDTO;
import br.com.atom.sgab_rest_api.model.dto.SecaoDTO;
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

    public SecaoDTO create(Secao secao){
        return parseObject(secaoRepository.save(secao), SecaoDTO.class);
    }

    public SecaoDTO update(Secao secao){
        var entity = secaoRepository.findById(secao.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Seção não encontrada."));
        entity.setDescricao(secao.getDescricao());
        return parseObject((secaoRepository.save(secao)), SecaoDTO.class);
    }

    public void delete(Long id){
        var entity =  secaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Seção não encontrada."));
        secaoRepository.delete(entity);
    }

    public List<SecaoDTO> findAll() {
        var entity = secaoRepository.findAll();
        if(entity.isEmpty()) {
            throw new ResourceNotFoundException("Nenhuma seção encontrada.");
        }
        return parseListObjects(entity, SecaoDTO.class);
    }

    public SecaoDTO findById(Long id) {
        var entity = secaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Seção não encontrada."));
        return parseObject(entity, SecaoDTO.class);
    }
}
