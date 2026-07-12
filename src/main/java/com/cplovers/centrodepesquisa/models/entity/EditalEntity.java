package com.cplovers.centrodepesquisa.models.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("tb_edital")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column("titulo")
    private String titulo;

    @Column("numero")
    private int numero;

    @Column("ano")
    private int ano;

    @Column("inicio_submissao")
    private LocalDate inicioSubmissao;
    @Column("fim_submissao")
    private LocalDate fimSubmissao;

    @Column("inicio_avaliacao")
    private LocalDate inicioAvaliacao;
    @Column("fim_avaliacao")
    private LocalDate fimAvaliacao;



}
