package com.estoke.web.controller.produto;

import com.estoke.core.produto.model.ProdutoDTO;
import com.estoke.core.produto.service.ProdutoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vitor.alves
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/internal/v1/produto")
@Validated
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping(path = "/catalogo/{catalogoId}")
    public ResponseEntity<List<ProdutoDTO>> findProdutosByCatalogo(@PathVariable Long catalogoId) {
        return ResponseEntity.ok(service.findProdutoByCatalogo(catalogoId));
    }
}
