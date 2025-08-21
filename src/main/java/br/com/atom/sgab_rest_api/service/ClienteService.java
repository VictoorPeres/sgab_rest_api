package br.com.atom.sgab_rest_api.service;

import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseObject;
import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseListObjects;

import br.com.atom.sgab_rest_api.exception.BusinessRuleException;
import br.com.atom.sgab_rest_api.exception.ResourceNotFoundException;
import br.com.atom.sgab_rest_api.model.dto.ClienteDTO;
import br.com.atom.sgab_rest_api.model.entity.Cliente;
import br.com.atom.sgab_rest_api.model.dto.ClienteCreateDTO;
import br.com.atom.sgab_rest_api.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteCreateDTO create(ClienteDTO cliente) {
        if(clienteRepository.findByCpf(cliente.getCpf()) != null) {
            throw new BusinessRuleException("Já existe um cliente cadastrado com o CPF informado.");
        }
        var entity = parseObject(cliente, Cliente.class);
        return parseObject(clienteRepository.save(entity), ClienteCreateDTO.class);
    }

    public ClienteDTO update(ClienteDTO clienteRequestDTO) {

        Cliente cliente = clienteRepository.findById(clienteRequestDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        cliente.setNome(clienteRequestDTO.getNome());
        cliente.setEmail(clienteRequestDTO.getEmail());
        cliente.setTelefone(clienteRequestDTO.getTelefone());

        return parseObject(clienteRepository.save(cliente), ClienteDTO.class);
    }

    public void delete(Long id) {
        var entity =  clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        if(entity != null){
            clienteRepository.delete(entity);
        }
    }

    public ClienteDTO findById(Long id) {

        var entity =  clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return parseObject(entity, ClienteDTO.class);
    }

    public ClienteDTO findByCpf(String cpf) {
        var entity = clienteRepository.findByCpf(cpf);
        if(entity == null) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        return parseObject(entity, ClienteDTO.class);
    }

    public List<ClienteDTO> findByFiltro(String filtro) {
        var entity = clienteRepository.findByFiltro(filtro);
        return parseListObjects(entity, ClienteDTO.class);
    }

    public List<ClienteDTO> findAll() {
        var entity = clienteRepository.findAll();
        return parseListObjects(entity, ClienteDTO.class);
    }

}
