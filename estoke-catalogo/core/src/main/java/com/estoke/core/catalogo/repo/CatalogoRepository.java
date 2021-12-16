package com.estoke.core.catalogo.repo;

import com.estoke.core.catalogo.domain.Catalogo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vitor.alves
 */
@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {

    List<Catalogo> findAllByRepresentanteIdentificador(Long representanteId);
}
