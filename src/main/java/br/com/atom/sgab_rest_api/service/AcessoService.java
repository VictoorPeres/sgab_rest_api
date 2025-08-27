package br.com.atom.sgab_rest_api.service;

import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseObject;
import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseListObjects;
import br.com.atom.sgab_rest_api.exception.BusinessRuleException;
import br.com.atom.sgab_rest_api.exception.ResourceNotFoundException;
import br.com.atom.sgab_rest_api.model.dto.AcessoDTO;
import br.com.atom.sgab_rest_api.model.entity.Acesso;
import br.com.atom.sgab_rest_api.model.repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcessoService {

    @Autowired
    private AcessoRepository acessoRepository;

    public AcessoDTO create(Acesso acesso){
        return parseObject(acessoRepository.save(acesso), AcessoDTO.class);
    }

    public AcessoDTO update(Acesso acesso){
        var entity = acessoRepository.findById(acesso.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Acesso não encontrado."));
        entity.setNome(acesso.getNome());
        entity.setDescricao(acesso.getDescricao());
        return parseObject(acessoRepository.save(entity), AcessoDTO.class);
    }

    public void delete(Long id) {
        var entity = acessoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Acesso não encontrado."));
        acessoRepository.delete(entity);
    }

    public List<AcessoDTO> findAll() {
        var entity = acessoRepository.findAll();
        if(entity.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum acesso encontrado.");
        }
        return parseListObjects(entity, AcessoDTO.class);
    }

    public AcessoDTO findById(Long id) {
        return parseObject(acessoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Acesso não encontrado.")), AcessoDTO.class);
    }
}
