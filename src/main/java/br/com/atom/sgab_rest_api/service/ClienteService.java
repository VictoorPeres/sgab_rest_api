package br.com.atom.sgab_rest_api.service;

import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseObject;
import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseListObjects;

import br.com.atom.sgab_rest_api.exception.BusinessRuleException;
import br.com.atom.sgab_rest_api.model.dto.ClienteRequestDTO;
import br.com.atom.sgab_rest_api.model.entity.Cliente;
import br.com.atom.sgab_rest_api.model.dto.ClienteResponseDTO;
import br.com.atom.sgab_rest_api.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponseDTO create(ClienteRequestDTO cliente) {
        if(clienteRepository.findByCpf(cliente.getCpf()) != null) {
            throw new BusinessRuleException("Já existe um cliente cadastrado com o CPF informado.");
        }
        var entity = parseObject(cliente, Cliente.class);
        return parseObject(clienteRepository.save(entity), ClienteResponseDTO.class);
    }

    public ClienteResponseDTO update(ClienteRequestDTO cliente) {
        var entity = parseObject(findById(cliente.getId()), Cliente.class);
        if(entity != null){
            return parseObject(clienteRepository.save(entity), ClienteResponseDTO.class);
        }
        return null;
    }

    public void delete(Long id) {
        ClienteResponseDTO cliente = findById(id);
        if(cliente != null){
            var entity = parseObject(cliente, Cliente.class);
            clienteRepository.delete(entity);
        }
    }

    public ClienteResponseDTO findById(Long id) {

        var entity =  clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente not found"));
        return parseObject(entity, ClienteResponseDTO.class);
    }

    public ClienteResponseDTO findByCpf(String cpf) {
        var entity = clienteRepository.findByCpf(cpf);
        return parseObject(entity, ClienteResponseDTO.class);
    }

    public List<ClienteResponseDTO> findByFiltro(String filtro) {
        var entity = clienteRepository.findByFiltro(filtro);
        return parseListObjects(entity, ClienteResponseDTO.class);
    }

    public List<ClienteResponseDTO> findAll() {
        var entity = clienteRepository.findAll();
        return parseListObjects(entity, ClienteResponseDTO.class);
    }

}
