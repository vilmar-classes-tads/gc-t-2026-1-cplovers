package com.cplovers.centrodepesquisa.Edital;

import com.cplovers.centrodepesquisa.Edital.dtos.EditalDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editais")
public class EditalController {

    private final EditalService service;

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