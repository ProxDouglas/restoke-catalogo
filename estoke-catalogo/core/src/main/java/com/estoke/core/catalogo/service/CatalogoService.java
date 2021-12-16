package com.estoke.core.catalogo.service;

import com.estoke.core.catalogo.domain.Catalogo;
import com.estoke.core.catalogo.mapper.CatalogoMapper;
import com.estoke.core.catalogo.model.CadastroCatalogoDTO;
import com.estoke.core.catalogo.model.CatalogoDTO;
import com.estoke.core.catalogo.model.CatalogoSimplesDTO;
import com.estoke.core.catalogo.repo.CatalogoRepository;
import com.estoke.core.produto.domian.Produto;
import com.estoke.core.produto.service.ProdutoService;
import com.estoke.core.representante.domain.Representante;
import com.estoke.core.representante.service.RepresentanteService;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author vitor.alves
 */
@Service
@RequiredArgsConstructor
public class CatalogoService {

    private final CatalogoRepository repository;
    private final CatalogoMapper mapper;
    private final ProdutoService produtoService;
    private final RepresentanteService representanteService;

    public CatalogoDTO cadastrar(CadastroCatalogoDTO cadastroCatalogoDTO) {
        List<Produto> produtos = produtoService.cadastrarProdutos(cadastroCatalogoDTO.getProdutos());
        Representante representante = representanteService.findOrCreate(cadastroCatalogoDTO.getRepresentante());
        Catalogo catalogo = mapper.creat(cadastroCatalogoDTO.getNome(), produtos, representante);
        return mapper.toModel(repository.save(catalogo));
    }

    public List<CatalogoSimplesDTO> findCatalogosByRepresentante(Long representanteId) {
        return mapper.mapSimples(repository.findAllByRepresentanteIdentificador(representanteId));
    }

    public CatalogoDTO delete(Long id) {
        Catalogo catalogo = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format("Nao existe catalogo com id: %s", id)));
        repository.delete(catalogo);
        return mapper.toModel(catalogo);
    }
}
