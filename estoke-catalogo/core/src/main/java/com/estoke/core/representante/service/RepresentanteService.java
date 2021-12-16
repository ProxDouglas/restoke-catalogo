package com.estoke.core.representante.service;

import com.estoke.api.representante.api.RepresentanteOperations;
import com.estoke.core.representante.domain.Representante;
import com.estoke.core.representante.mapper.RepresentanteMapper;
import com.estoke.core.representante.repo.RepresentanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author vitor.alves
 */
@Service
@RequiredArgsConstructor
public class RepresentanteService {

    private final RepresentanteRepository repository;
    private final RepresentanteOperations operations;
    private final RepresentanteMapper mapper;

    public Representante findOrCreate(Long identificador) {
        if (repository.existsByIdentificador(identificador)) {
            return repository.findByIdentificador(identificador);
        }
        return repository.save(mapper.toEntity(operations.findStubById(identificador).getBody()));
    }
}
