package com.cplovers.centrodepesquisa.models.repository;

import com.cplovers.centrodepesquisa.models.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ListCrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
}
