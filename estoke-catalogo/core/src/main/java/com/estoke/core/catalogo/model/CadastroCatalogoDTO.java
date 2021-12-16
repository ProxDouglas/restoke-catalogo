package com.estoke.core.catalogo.model;

import java.util.List;
import lombok.Data;

/**
 * @author vitor.alves
 */
@Data
public class CadastroCatalogoDTO {

    private String nome;

    private Long representante;

    private List<Long> produtos;
}
