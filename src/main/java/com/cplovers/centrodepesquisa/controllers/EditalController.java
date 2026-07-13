package com.cplovers.centrodepesquisa.controllers;

import com.cplovers.centrodepesquisa.models.dtos.EditalDto;
import com.cplovers.centrodepesquisa.models.entity.EditalEntity;
import com.cplovers.centrodepesquisa.services.EditalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editais")
public class EditalController {

    private final EditalService service;

    @Autowired
    public EditalController(EditalService service) {
        this.service = service;
    }

    @PostMapping
    public EditalEntity criar(
            @Valid @RequestBody EditalDto dto
    ) {
        return service.createEdital(dto);
    }

    @GetMapping
    public List<EditalDto> listar() {
        return service.getEdital();
    }
}