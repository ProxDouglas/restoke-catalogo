package com.estoke.core.catalogo.mapper;

import com.estoke.core.catalogo.domain.Catalogo;
import com.estoke.core.catalogo.model.CatalogoDTO;
import com.estoke.core.catalogo.model.CatalogoSimplesDTO;
import com.estoke.core.produto.domian.Produto;
import com.estoke.core.produto.mapper.ProdutoMapper;
import com.estoke.core.representante.domain.Representante;
import com.estoke.core.representante.mapper.RepresentanteMapper;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author vitor.alves
 */
@Mapper(componentModel = "spring")
public abstract class CatalogoMapper {

    @Autowired
    protected ProdutoMapper produtoMapper;
    @Autowired
    protected RepresentanteMapper representanteMapper;

    @Mapping(target = "produtos", expression = "java(produtoMapper.map(model.getProdutos()))")
    @Mapping(target = "representante", expression = "java(representanteMapper.toEntity(model.getRepresentante()))")
    public abstract Catalogo toEntity(CatalogoDTO model);

    @Mapping(target = "representante", source = "representante")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "id", ignore = true)
    public abstract Catalogo creat(String nome, List<Produto> produtos, Representante representante);

    @Mapping(target = "produtos", expression = "java(produtoMapper.mapModel(entity.getProdutos()))")
    @Mapping(target = "representante", expression = "java(representanteMapper.toModel(entity.getRepresentante()))")
    public abstract CatalogoDTO toModel(Catalogo entity);

    public abstract List<CatalogoSimplesDTO> mapSimples(List<Catalogo> entites);

    public abstract CatalogoSimplesDTO toModelSimples(Catalogo entity);
}
