package com.cplovers.centrodepesquisa.services;

import com.cplovers.centrodepesquisa.models.dtos.CreateUserDto;
import com.cplovers.centrodepesquisa.models.entity.UserEntity;
import com.cplovers.centrodepesquisa.models.entity.UserRole;
import com.cplovers.centrodepesquisa.models.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public String createUser(@NonNull CreateUserDto data) {

        if(userRepository.existsByCpf(data.cpf()))
            throw new IllegalArgumentException("CPF já cadastrado");

        if(userRepository.existsByEmail(data.email()))
            throw new IllegalArgumentException("Email já cadastrado.");

        var Entity = new UserEntity();
        var roles = new HashSet<UserRole>();
        roles.add(new UserRole(1));
        roles.add(new UserRole(2));

        Entity.setRoles(roles);
        Entity.setCpf(data.cpf());
        Entity.setName(data.name());
        Entity.setSocialName(data.socialName());
        Entity.setEmail(data.email());
        Entity.setPassword(passwordEncoder.encode(data.password()));
        Entity.setCampus(data.campus());
        Entity.setFormacao(data.formacao());
        Entity.setTitulacao(data.titulacao());
        Entity.setSexo(data.sexo());
        Entity.setLattes(data.lattes());
        Entity.setTelefone(data.telefone());
        System.out.println(">>>>>>>>>>>>>> Antes do save: " + Entity.getCpf());
        var savedUser = userRepository.save(Entity);
        System.out.println(">>>>>>>>>>>>>> Depois do save: " + savedUser.getCpf());

        return savedUser.getCpf();
    };
}
