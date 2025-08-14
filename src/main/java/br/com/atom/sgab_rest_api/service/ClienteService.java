package br.com.atom.sgab_rest_api.service;

import br.com.atom.sgab_rest_api.model.entity.Cliente;
import br.com.atom.sgab_rest_api.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        Cliente c = findById(cliente.getId());
        if(c != null){
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public void delete(Long id) {
        Cliente cliente = findById(id);
        if(cliente != null){
            clienteRepository.delete(cliente);
        }
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente not found"));
    }

    public Cliente findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public List<Cliente> findByFiltro(String filtro) {
        return clienteRepository.findByFiltro(filtro);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

}
