package com.cplovers.centrodepesquisa.models.repository;

import com.cplovers.centrodepesquisa.models.entity.EditalEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditalRepository extends ListCrudRepository<EditalEntity, Long> {
}
