package br.com.atom.sgab_rest_api.controller;

import br.com.atom.sgab_rest_api.model.dto.ClienteDTO;
import br.com.atom.sgab_rest_api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ClienteDTO> findAll() {
        return clienteService.findAll();
    }

    @GetMapping(value = "/cpf/{cpf}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ClienteDTO findByCpf(@PathVariable("cpf") String cpf) {
        return clienteService.findByCpf(cpf);
    }

    @GetMapping(value = "/consulta/{filtro}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ClienteDTO> findByFiltro(@PathVariable String filtro) {
        System.out.println(filtro);
        return clienteService.findByFiltro(filtro);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ClienteDTO create(@RequestBody ClienteDTO clienteRequest) {
        return clienteService.create(clienteRequest);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ClienteDTO update(@RequestBody ClienteDTO clienteRequest) {
        return clienteService.update(clienteRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
