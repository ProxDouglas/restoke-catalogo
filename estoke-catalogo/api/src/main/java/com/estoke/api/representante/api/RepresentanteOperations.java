package com.estoke.api.representante.api;

import com.estoke.api.representante.model.RepresentanteStub;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author vitor.alves
 */
@FeignClient(name = "representante", url = "http://localhost:8087/restoke/api/internal/v1/represntantes")
public interface RepresentanteOperations {

    @GetMapping(path = "/stub/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RepresentanteStub> findStubById(@PathVariable Long id);
}
