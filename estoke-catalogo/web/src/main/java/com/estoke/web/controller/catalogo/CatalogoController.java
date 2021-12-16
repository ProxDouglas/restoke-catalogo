package com.estoke.web.controller.catalogo;

import com.estoke.core.catalogo.model.CadastroCatalogoDTO;
import com.estoke.core.catalogo.model.CatalogoDTO;
import com.estoke.core.catalogo.model.CatalogoSimplesDTO;
import com.estoke.core.catalogo.service.CatalogoService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vitor.alves
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/internal/v1/catalogo")
@Validated
@AllArgsConstructor
public class CatalogoController {

    private final CatalogoService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CatalogoDTO> cadastrar(@Valid @RequestBody CadastroCatalogoDTO cadastroCatalogoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(cadastroCatalogoDTO));
    }

    @GetMapping(path = "/representante/{representanteId}")
    public ResponseEntity<List<CatalogoSimplesDTO>> findCatalogoSimplesByRepresentante(@PathVariable Long representanteId) {
        return ResponseEntity.ok(service.findCatalogosByRepresentante(representanteId));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<CatalogoDTO> deleteBy(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
