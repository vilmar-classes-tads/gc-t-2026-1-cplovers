package com.cplovers.centrodepesquisa.Edital;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditalRepository extends ListCrudRepository< EditalEntity, Long> {
}
