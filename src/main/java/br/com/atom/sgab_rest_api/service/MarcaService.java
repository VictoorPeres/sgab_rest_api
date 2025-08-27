package br.com.atom.sgab_rest_api.service;

import br.com.atom.sgab_rest_api.exception.ResourceNotFoundException;
import br.com.atom.sgab_rest_api.mapper.ObjectMapper;
import br.com.atom.sgab_rest_api.model.dto.MarcaDTO;
import br.com.atom.sgab_rest_api.model.entity.Marca;
import br.com.atom.sgab_rest_api.model.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class MarcaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private MarcaRepository marcaRepository;

    public MarcaDTO create(MarcaDTO marcaDTO){
        var entity = ObjectMapper.parseObject(marcaDTO, Marca.class);
        return ObjectMapper.parseObject(marcaRepository.save(entity), MarcaDTO.class);
    }

    public MarcaDTO update(MarcaDTO marcaDTO) {
        Marca marca = marcaRepository.findById(marcaDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Marca não encontrada."));
        marca.setDescricao(marcaDTO.getDescricao());
        return ObjectMapper.parseObject(marcaRepository.save(marca), MarcaDTO.class);
    }

    public void delete(Long id){
        var entity =  marcaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Marca não encontrada."));
        marcaRepository.delete(entity);
    }

    public List<MarcaDTO> findAll(){
        var entity = marcaRepository.findAll();
        if(entity.isEmpty()) {
            throw new ResourceNotFoundException("Nenhuma marca encontrada.");
        }
        return ObjectMapper.parseListObjects(entity, MarcaDTO.class);
    }

    public MarcaDTO findById(Long id) {
        return ObjectMapper.parseObject(marcaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Marca não encontrada.")), MarcaDTO.class);
    }
}
