package com.estoke.core.produto.repo;

import com.estoke.core.produto.domian.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vitor.alves
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
