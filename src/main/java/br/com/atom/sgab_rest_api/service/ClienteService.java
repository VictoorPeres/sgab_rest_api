package br.com.atom.sgab_rest_api.service;

import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseObject;
import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseListObjects;

import br.com.atom.sgab_rest_api.model.entity.Cliente;
import br.com.atom.sgab_rest_api.model.dto.ClienteDTO;
import br.com.atom.sgab_rest_api.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO create(ClienteDTO cliente) {
        var entity = parseObject(cliente, Cliente.class);
        return parseObject(clienteRepository.save(entity), ClienteDTO.class);
    }

    public ClienteDTO update(ClienteDTO cliente) {
        var entity = parseObject(findById(cliente.getId()), Cliente.class);
        if(entity != null){
            return parseObject(clienteRepository.save(entity), ClienteDTO.class);
        }
        return null;
    }

    public void delete(Long id) {
        ClienteDTO cliente = findById(id);
        if(cliente != null){
            var entity = parseObject(cliente, Cliente.class);
            clienteRepository.delete(entity);
        }
    }

    public ClienteDTO findById(Long id) {

        var entity =  clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente not found"));
        return parseObject(entity, ClienteDTO.class);
    }

    public ClienteDTO findByCpf(String cpf) {
        var entity = clienteRepository.findByCpf(cpf);
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
