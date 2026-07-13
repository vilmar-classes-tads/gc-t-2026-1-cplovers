package com.cplovers.centrodepesquisa.models.repository;

import com.cplovers.centrodepesquisa.models.entity.RoleEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends ListCrudRepository<RoleEntity, Long> {
}
