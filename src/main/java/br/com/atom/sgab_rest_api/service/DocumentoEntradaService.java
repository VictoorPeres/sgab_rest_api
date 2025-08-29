package br.com.atom.sgab_rest_api.service;

import br.com.atom.sgab_rest_api.exception.ResourceNotFoundException;
import br.com.atom.sgab_rest_api.model.dto.DocumentoEntradaDTO;
import br.com.atom.sgab_rest_api.model.entity.DocumentoEntrada;
import br.com.atom.sgab_rest_api.model.repository.DocumentoEntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseObject;
import static br.com.atom.sgab_rest_api.mapper.ObjectMapper.parseListObjects;


@Service
public class DocumentoEntradaService {

    @Autowired
    private DocumentoEntradaRepository documentoEntradaRepository;

    public DocumentoEntradaDTO create(DocumentoEntrada documentoEntrada) {
        return parseObject(documentoEntradaRepository.save(documentoEntrada), DocumentoEntradaDTO.class);
    }

    public DocumentoEntradaDTO update(DocumentoEntrada documentoEntrada){
        var entity = documentoEntradaRepository.findById(documentoEntrada.getId()).orElseThrow(() -> new ResourceNotFoundException("Documento não encontrado"));
        entity.setDescricao(documentoEntrada.getDescricao());
        entity.setNrSerieEmprestimo(documentoEntrada.getNrSerieEmprestimo());
        entity.setDtPrevisaoSaida(documentoEntrada.getDtPrevisaoSaida());
        entity.setUsuario(documentoEntrada.getUsuario());
        return parseObject(documentoEntradaRepository.save(entity), DocumentoEntradaDTO.class);
    }
}
