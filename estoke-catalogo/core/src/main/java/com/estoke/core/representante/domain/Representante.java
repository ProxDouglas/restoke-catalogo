package com.estoke.core.representante.domain;

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
@Table(name = "REPRESENTANTE")
@SequenceGenerator(name = "SEQ_REP", sequenceName = "SEQ_REP")
public class Representante {

    @Id
    @GeneratedValue(generator = "SEQ_REP")
    @Column(name = "COD_REP")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "IDENTIFICADOR", unique = true)
    private Long identificador;
}
