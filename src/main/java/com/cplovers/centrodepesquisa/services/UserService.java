package com.cplovers.centrodepesquisa.services;

import com.cplovers.centrodepesquisa.models.dtos.CreateUserDto;
import com.cplovers.centrodepesquisa.models.entity.RoleEntity;
import com.cplovers.centrodepesquisa.models.entity.UserEntity;
import com.cplovers.centrodepesquisa.models.repository.RoleRepository;
import com.cplovers.centrodepesquisa.models.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public String createUser(@NonNull CreateUserDto data) {

        if (userRepository.existsByCpf(data.cpf()))
            throw new IllegalArgumentException("CPF já cadastrado");

        if (userRepository.existsByEmail(data.email()))
            throw new IllegalArgumentException("Email já cadastrado.");

        var entity = new UserEntity();
        var roles = new HashSet<RoleEntity>();

        roles.add(roleRepository.findById(1L)
                .orElseThrow(() -> new IllegalStateException("Role padrão 1 não encontrada")));
        roles.add(roleRepository.findById(2L)
                .orElseThrow(() -> new IllegalStateException("Role padrão 2 não encontrada")));

        entity.setRoles(roles);
        entity.setCpf(data.cpf());
        entity.setName(data.name());
        entity.setSocialName(data.socialName());
        entity.setEmail(data.email());
        entity.setPassword(passwordEncoder.encode(data.password()));
        entity.setCampus(data.campus());
        entity.setFormacao(data.formacao());
        entity.setTitulacao(data.titulacao());
        entity.setSexo(data.sexo());
        entity.setLattes(data.lattes());
        entity.setTelefone(data.telefone());
        System.out.println(">>>>>>>>>>>>>> Antes do save: " + entity.getCpf());
        var savedUser = userRepository.save(entity);
        System.out.println(">>>>>>>>>>>>>> Depois do save: " + savedUser.getCpf());

        return savedUser.getCpf();
    }
}
