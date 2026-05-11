package com.cplovers.centrodepesquisa.Edital;

import com.cplovers.centrodepesquisa.Edital.dtos.EditalDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditalService {

    private EditalRepository editalRepository;

    public EditalService(EditalRepository editalRepository) {
        this.editalRepository = editalRepository;
    }

    public List<EditalDto> getEdital(){
        return editalRepository.findAll()
                .stream()
                .map(edital -> new EditalDto(
                        edital.getTitulo(),
                        edital.getNumero(),
                        edital.getAno(),
                        edital.getInicioSubmissao(),
                        edital.getFimSubmissao(),
                        edital.getInicioAvaliacao(),
                        edital.getFimAvaliacao()
                )).toList();
    }

    public EditalEntity createEdital(EditalDto dto){
         EditalEntity edital = new EditalEntity();

        if(dto.inicioSubmissao().isAfter(dto.fimSubmissao())) {
            throw new RuntimeException(
                    "A data de início da submissão não pode ser maior que a data final"
            );
        }

        if(dto.inicioAvaliacao().isAfter(dto.fimAvaliacao())) {
            throw new RuntimeException(
                    "A data de início da avaliação não pode ser maior que a data final"
            );
        }

         edital.setTitulo(dto.titulo());
         edital.setNumero(dto.numero());
         edital.setAno(dto.ano());
         edital.setInicioSubmissao(dto.inicioSubmissao());
         edital.setFimSubmissao(dto.fimSubmissao());
         edital.setInicioAvaliacao(dto.inicioAvaliacao());
         edital.setFimAvaliacao(dto.fimAvaliacao());

         return editalRepository.save(edital);


    }


}
