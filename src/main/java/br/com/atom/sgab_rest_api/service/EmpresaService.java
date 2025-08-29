package br.com.atom.sgab_rest_api.service;

import br.com.atom.sgab_rest_api.exception.ResourceNotFoundException;
import br.com.atom.sgab_rest_api.model.dto.EmpresaDTO;
import br.com.atom.sgab_rest_api.model.dto.EmpresaRequestDTO;
import br.com.atom.sgab_rest_api.model.entity.Empresa;
import br.com.atom.sgab_rest_api.model.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseObject;
import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseListObjects;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaDTO create (EmpresaRequestDTO empresaRequestDTO){
        var entity = parseObject(empresaRequestDTO, Empresa.class);

        if(empresaRequestDTO.getIdDistribuidora() != null){
            var distribuidora = empresaRepository.findById(empresaRequestDTO.getIdDistribuidora()).orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada"));
            entity.setDistribuidora(distribuidora);
        }
        entity = empresaRepository.save(entity);

        return parseObject(entity, EmpresaDTO.class);
    }

    public EmpresaDTO update(EmpresaRequestDTO empresaRequestDTO){
        var entity = empresaRepository.findById(empresaRequestDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada"));
        var distribuidora = empresaRepository.findById(empresaRequestDTO.getIdDistribuidora()).orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada"));

        entity.setNomeFantasia(empresaRequestDTO.getNomeFantasia());
        entity.setRazaoSocial(empresaRequestDTO.getRazaoSocial());
        entity.setEmail(empresaRequestDTO.getEmail());
        entity.setTelefone(empresaRequestDTO.getTelefone());
        entity.setTipoEmpresa(empresaRequestDTO.getTipoEmpresa());
        entity.setDistribuidora(distribuidora);

        return parseObject(empresaRepository.save(entity), EmpresaDTO.class);
    }

    public void delete(Long id){
        var entity = empresaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada"));
        empresaRepository.delete(entity);
    }

    public List<EmpresaDTO> findAll(){
        var entity = empresaRepository.findAll();
        return parseListObjects(entity, EmpresaDTO.class);
    }

    public EmpresaDTO findById(Long id){
        var entity = empresaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada"));
        return parseObject(entity, EmpresaDTO.class);
    }

    public List<EmpresaDTO> findByFiltro(String filtro){
        var entity = empresaRepository.findByFiltro(filtro);
        if(entity.isEmpty()){
            throw new ResourceNotFoundException("Nenhuma empresa encontrada com o filtro informado");
        }
        return parseListObjects(entity, EmpresaDTO.class);
    }
}
