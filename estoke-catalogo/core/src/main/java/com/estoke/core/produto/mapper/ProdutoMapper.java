package com.estoke.core.produto.mapper;

import com.estoke.api.produto.model.ProdutoStub;
import com.estoke.core.produto.domian.Produto;
import com.estoke.core.produto.model.ProdutoDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author vitor.alves
 */
@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    List<Produto> map(List<ProdutoDTO> entities);

    Produto toEntity(ProdutoDTO model);

    @Mapping(target = "identificador", source = "id")
    Produto toEntity(ProdutoStub stub);

    List<ProdutoDTO> mapModel(List<Produto> entities);

    ProdutoDTO toModel(Produto entity);

}
