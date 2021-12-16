package com.estoke.core.produto.domian;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author vitor.alves
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUTO")
@SequenceGenerator(name = "SEQ_PROD", sequenceName = "SEQ_PROD")
public class Produto {

    @Id
    @GeneratedValue(generator = "SEQ_PROD")
    @Column(name = "COD_PROD")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "IDENTIFICADOR")
    private Long identificador;
}
