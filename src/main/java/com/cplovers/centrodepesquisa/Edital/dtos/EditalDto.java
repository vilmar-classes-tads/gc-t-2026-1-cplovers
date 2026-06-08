package com.cplovers.centrodepesquisa.Edital.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EditalDto(
        @NotBlank
        String titulo,
        @NotNull
        int numero,
        @NotNull
        int ano,
        @NotNull
        LocalDate inicioSubmissao,
        @NotNull
        LocalDate fimSubmissao,
        @NotNull
        LocalDate inicioAvaliacao,
        @NotNull
        LocalDate fimAvaliacao
) {
}
