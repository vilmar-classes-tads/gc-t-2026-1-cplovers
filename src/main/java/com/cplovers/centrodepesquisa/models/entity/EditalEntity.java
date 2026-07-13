package com.cplovers.centrodepesquisa.models.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_edital")
public class EditalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "ano", nullable = false)
    private int ano;

    @Column(name = "inicio_submissao")
    private LocalDate inicioSubmissao;
    @Column(name = "fim_submissao")
    private LocalDate fimSubmissao;

    @Column(name = "inicio_avaliacao")
    private LocalDate inicioAvaliacao;
    @Column(name = "fim_avaliacao")
    private LocalDate fimAvaliacao;



}
