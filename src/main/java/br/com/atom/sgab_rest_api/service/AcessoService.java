package br.com.atom.sgab_rest_api.service;

import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseObject;
import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseListObjects;
import br.com.atom.sgab_rest_api.exception.ResourceNotFoundException;
import br.com.atom.sgab_rest_api.model.dto.AcessoDTO;
import br.com.atom.sgab_rest_api.model.entity.Acesso;
import br.com.atom.sgab_rest_api.model.repository.AcessoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcessoService {

    @Autowired
    private AcessoRepository acessoRepository;

    @Transactional
    public AcessoDTO create(AcessoDTO acessoDTO){
        var entity = parseObject(acessoDTO, Acesso.class);
        return parseObject(acessoRepository.save(entity), AcessoDTO.class);
    }

    @Transactional
    public AcessoDTO update(AcessoDTO acessoDTO){
        var entity = acessoRepository.findById(acessoDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Acesso não encontrado."));
        entity.setNome(acessoDTO.getNome());
        entity.setDescricao(acessoDTO.getDescricao());
        return parseObject(acessoRepository.save(entity), AcessoDTO.class);
    }

    @Transactional
    public void delete(Long id) {
        var entity = acessoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Acesso não encontrado."));
        acessoRepository.delete(entity);
    }

    @Transactional
    public List<AcessoDTO> findAll() {
        var entity = acessoRepository.findAll();
        return parseListObjects(entity, AcessoDTO.class);
    }

    @Transactional
    public AcessoDTO findById(Long id) {
        return parseObject(acessoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Acesso não encontrado.")), AcessoDTO.class);
    }
}
