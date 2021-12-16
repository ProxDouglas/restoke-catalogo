package com.estoke.core.produto.service;

import com.estoke.api.produto.api.ProdutoOperations;
import com.estoke.api.produto.model.ProdutoStub;
import com.estoke.core.catalogo.repo.CatalogoRepository;
import com.estoke.core.produto.domian.Produto;
import com.estoke.core.produto.mapper.ProdutoMapper;
import com.estoke.core.produto.model.ProdutoDTO;
import com.estoke.core.produto.repo.ProdutoRepository;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author vitor.alves
 */
@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoOperations operations;
    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;
    private final CatalogoRepository catalogoRepository;

    public List<Produto> cadastrarProdutos(List<Long> idProdutos) {
        List<ProdutoStub> body = operations.findAllByIds(idProdutos).getBody();
        if (body == null) {
            return Collections.emptyList();
        }
        return repository.saveAll(body.stream().map(mapper::toEntity).collect(Collectors.toList()));
    }

    public List<ProdutoDTO> findProdutoByCatalogo(Long catalogoId) {
        return mapper.mapModel(catalogoRepository.findById(catalogoId)
            .orElseThrow(() -> new EntityNotFoundException(String.format("Nao existe catalogo com id: %s", catalogoId))).getProdutos());
    }
}
