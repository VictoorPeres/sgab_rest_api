package br.com.atom.sgab_rest_api.controller;

import br.com.atom.sgab_rest_api.model.dto.ClienteDTO;
import br.com.atom.sgab_rest_api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cliente/v1")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO clienteRequest) {
        ClienteDTO clienteDTO =  clienteService.create(clienteRequest);
        return ResponseEntity.created(URI.create("/cliente/" + clienteDTO.getId())).body(clienteDTO);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ClienteDTO update(@Valid @RequestBody ClienteDTO clienteRequest) {
        return clienteService.update(clienteRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

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
        return clienteService.findByFiltro(filtro);
    }
}
