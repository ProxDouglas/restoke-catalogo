package com.estoke.api.produto.api;

import com.estoke.api.produto.model.ProdutoStub;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author vitor.alves
 */
@FeignClient(name = "produto", url = "http://localhost:8087/restoke/api/internal/v1/produtos")
public interface ProdutoOperations {

    @GetMapping(path = "/stubs", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProdutoStub>> findAllByIds(@RequestParam List<Long> ids);

}
