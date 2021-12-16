package com.estoke.core.catalogo.model;

import com.estoke.core.produto.model.ProdutoDTO;
import com.estoke.core.representante.model.RepresentanteDTO;
import java.util.List;
import lombok.Data;

/**
 * @author vitor.alves
 */
@Data
public class CatalogoDTO {

    private Long id;

    private String nome;

    private List<ProdutoDTO> produtos;

    private RepresentanteDTO representante;
}
