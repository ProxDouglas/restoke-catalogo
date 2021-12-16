package com.estoke.core.catalogo.domain;

import com.estoke.core.produto.domian.Produto;
import com.estoke.core.representante.domain.Representante;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author vitor.alves
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CATALOGO")
@SequenceGenerator(name = "SEQ_CAT", sequenceName = "SEQ_CAT")
public class Catalogo {

    @Id
    @GeneratedValue(generator = "SEQ_CAT")
    @Column(name = "COD_CAT")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @ManyToMany
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "COD_REP", nullable = false)
    private Representante representante;
}
