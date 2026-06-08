package com.cplovers.centrodepesquisa.Edital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("tb_Edital")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditalEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("Titulo")
    private String titulo;

    @Column("Numero")
    private int numero;

    @Column("Ano")
    private int ano;

    @Column("inicioSubmissao")
    private LocalDate inicioSubmissao;
    @Column("fimSubmissao")
    private LocalDate fimSubmissao;

    @Column("inicioAvaliacao")
    private LocalDate inicioAvaliacao;
    @Column("fimAvaliacao")
    private LocalDate fimAvaliacao;



}
